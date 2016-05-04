package book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.DAOFactory;

import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/jsp/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //×ªÂë
	    PrintWriter out = response.getWriter();
		//PrintWriter out=response.getWriter();
		//String path = "houtai.jsp" ;
		String cartid = request.getParameter("cartid");
		try {
		if(DAOFactory.getICartDAOInstance().doRemove(cartid)){
			   
			response.setHeader("refresh","0;URL=buy_car.jsp" );
			 out.println("<script>");
			  out.println("alert('É¾³ý³É¹¦£¡');");
			  out.println("</script>");	
		}
			}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
