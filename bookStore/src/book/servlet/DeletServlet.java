package book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import book.factory.DAOFactory;

/**
 * Servlet implementation class DeletServlet
 */
@WebServlet("/jsp/DeletServlet")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ; 
		response.setContentType("text/html; charset=UTF-8"); //转码
	    PrintWriter out = response.getWriter();
		//PrintWriter out=response.getWriter();
		String path = "houtai.jsp" ;
		String bookId = request.getParameter("book_id");
		try {
		if(DAOFactory.getIProductDAOInstance().doRemove(bookId)){
			   
			response.setHeader("refresh","0;URL=houtai.jsp" );
			 out.println("<script>");
			  out.println("alert('删除成功！');");
			  out.println("</script>");
		}else {
			
			
		}
	} catch(SQLServerException eo){
		
	    response.setHeader("refresh","0;URL=houtai.jsp" );
	    out.println("<script>");
	    out.println("alert('此商品已产生交易，不能删除！');");
	    out.println("</script>");
	}catch (Exception e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
		
	}



 //   request.getRequestDispatcher(path).forward(request,response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
