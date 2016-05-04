package book.servlet;

import java.io.IOException;






import java.text.*;
import java.util.Date;
import java.io.PrintWriter;

import javax.servlet.jsp.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import book.factory.DAOFactory;
import book.vo.Product;
import book.util.*;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/jsp/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//request.setCharacterEncoding("gbk");
		
		request.setCharacterEncoding("utf-8") ; 
		response.setContentType("text/html; charset=UTF-8"); //转码
		PrintWriter out=response.getWriter();
		try{
			  JspFactory _jspxFactory = null;
		       PageContext pageContext = null;
		       _jspxFactory = JspFactory.getDefaultFactory();
		      pageContext = _jspxFactory.getPageContext(this, request,response, null, false, JspWriter.DEFAULT_BUFFER, true);
			
			SmartUpload smart = new SmartUpload() ;
			smart.initialize(pageContext) ;	// 初始化上传操作
			
			smart.upload() ;			// 上传准备
		  
			//限制上传文件的类型，允许格式为 jpg,gif,bmp
		   smart.setAllowedFilesList("jpg,gif,bmp");
		     //禁止文件上传类型
		   smart.setDeniedFilesList("exe,bat,jsp,htm,html,");
		  //  String name = smart.getRequest().getParameter("uname") ;
			IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr()) ;	// 取得客户端的IP地址
			String ext = smart.getFiles().getFile(0).getFileExt() ;	// 扩展名称
			String fileName = its.getIPTimeRand() + "." + ext ;
			String src1="../img/"+fileName;
			String src="\""+src1+"\"";
			
			smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/")+"img"+java.io.File.separator + fileName,smart.SAVE_PHYSICAL) ;
			//smart.save(this.getServletContext().getRealPath("/")+"img", 0);
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String bookId = sdf.format(new java.sql.Date(new java.util.Date().getTime()));
		String book_type=smart.getRequest().getParameter("book_type");
		String bookName=smart.getRequest().getParameter("book_name");
		String bookImg=smart.getRequest().getParameter("book_img");
		String author=smart.getRequest().getParameter("book_author");
		String publishing=smart.getRequest().getParameter("book_publishing");
		String introduct=smart.getRequest().getParameter("book_introduct");
		System.out.print(bookName.getBytes("utf-8"));
		Integer price=Integer.parseInt(smart.getRequest().getParameter("book_price"));
		
		Integer new_price=Integer.parseInt(smart.getRequest().getParameter("book_newprice"));
	     
		Date onsaleDate = new java.sql.Date(new java.util.Date().getTime());
		Integer num=Integer.parseInt(smart.getRequest().getParameter("book_num"));
		
		
			Product book = new Product() ;
			book.setBookId(bookId);
			book.setBook_type(book_type) ;
			book.setBookImg(src);
			book.setAuthor(author);
			book.setBookName(bookName);
			book.setIntroduct(introduct);
			book.setPublishing(publishing);
			book.setPrice(price);
			book.setNew_price(new_price);
			book.setOnsaleDate(onsaleDate);
			book.setCatalog("www");
			book.setNum(num);
			
				
					if(DAOFactory.getIProductDAOInstance().doCreate(book)){
						 out.println("<script>");
						    out.println("alert('添加商品成功！');");
						    out.println("</script>");
						response.setHeader("refresh","0;URL=houtai.jsp" );
						
					
					} else {
						 out.println("<script>");
						 out.println("alert('添加商品失败！');");
						  out.println("</script>");
						response.setHeader("refresh","2;URL=houtai.jsp" );
						
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
		this.doGet( request,response) ;
	}

}
