package book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import book.factory.DAOFactory;
import book.util.IPTimeStamp;
import book.vo.Member;
import book.vo.Product;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/jsp/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//request.setCharacterEncoding("gbk");
		response.setContentType("text/html; charset=UTF-8"); //转码
		request.setCharacterEncoding("utf-8") ;
		PrintWriter out=response.getWriter();
		
		try{
		String bookId = request.getParameter("book_id");
		String book_type=request.getParameter("book_type");
		String bookName=request.getParameter("book_name");
		String bookImg=request.getParameter("book_img");
		String author=request.getParameter("book_author");
		String publishing=request.getParameter("book_publishing");
		String introduct=request.getParameter("book_introduct");
		
		Integer price=Integer.parseInt(request.getParameter("book_price"));
		Integer new_price=Integer.parseInt(request.getParameter("book_newprice"));
	     
		Date onsaleDate = new java.sql.Date(new java.util.Date().getTime());
		Integer num=Integer.parseInt(request.getParameter("book_num"));
		
		
			Product book = new Product() ;
			book.setBookId(bookId);
			book.setBook_type(book_type) ;
			book.setBookImg(bookImg);
			book.setAuthor(author);
			book.setBookName(bookName);
			book.setIntroduct(introduct);
			book.setPublishing(publishing);
			book.setPrice(price);
			book.setNew_price(new_price);
			book.setOnsaleDate(onsaleDate);
			book.setCatalog("www");
			book.setNum(num);
			
				
					if(DAOFactory.getIProductDAOInstance().doUpdate(book)){
						
						out.println("<script>");
						out.println("alert('修改成功！')");
						out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					
					} else {
						
						out.println("<script>");
						out.println("alert('修改失败！')");
						out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					}
		 }
		catch (SmartUploadException ex) {
		    out.print(ex.toString());
		    
		  	
		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(e.toString());
					
				}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
