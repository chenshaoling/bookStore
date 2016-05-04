package book.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.cosnaming.IiopUrl.Address;

import book.factory.* ;
import book.vo.Order;
import book.vo.AddressInfo;
import book.vo.Product;

/**
 * Servlet implementation class BookInfoServlet
 */
@WebServlet("/jsp/BookInfoServlet")
public class BookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path ="buy.jsp";
		request.setCharacterEncoding("utf-8");
		String mid=request.getParameter("id");
		String bookId = request.getParameter("bookId") ;
		Integer chooseNum=Integer.parseInt(request.getParameter("chooseNum")); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss:SSS");
		String orderno = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+mid;
		String time=sdf2.format(new java.sql.Date(new java.util.Date().getTime()));
		Product book=new Product();
		try {
			 book=DAOFactory.getIProductDAOInstance().findById(bookId);
			 path ="buy.jsp";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order ord=new Order();
		ord.setOrderno(orderno);
		ord.setBookId(bookId);
		ord.setOrderState("Î´¸¶¿î");
		ord.setMid(mid);
		ord.setAddno("Î´ÌîÐ´");
		ord.setNum(chooseNum);
		ord.setFee(book.getNew_price()!=0?book.getNew_price():book.getPrice());
		ord.setTime(time);
		
		try{
			if(DAOFactory.getIOrderDAOInstance().doCreate(ord)){
				path ="buy.jsp";
			}
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer countFee=chooseNum*ord.getFee();
		request.setAttribute("bookId", book.getBookId());
		request.setAttribute("book_type", book.getBook_type());
		request.setAttribute("bookName", book.getBookName());
		request.setAttribute("bookImg", book.getBookImg());
		request.setAttribute("author", book.getAuthor());
		request.setAttribute("publishing", book.getPublishing());
		request.setAttribute("introduct", book.getIntroduct());
		request.setAttribute("price", book.getPrice());
		request.setAttribute("new_price", book.getNew_price());
		request.setAttribute("onsaleDate", book.getOnsaleDate());
		request.setAttribute("catalog", book.getCatalog());
		request.setAttribute("num", book.getNum());
		request.setAttribute("orderno", ord.getOrderno());
		request.setAttribute("orderState", ord.getOrderState());
		request.setAttribute("chooseNum", ord.getNum());
		request.setAttribute("fee", ord.getFee());
		request.setAttribute("countFee", countFee);
		request.getRequestDispatcher(path).forward(request,response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
