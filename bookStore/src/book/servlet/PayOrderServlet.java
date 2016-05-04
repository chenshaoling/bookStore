package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.DAOFactory;
import book.vo.Order;
import book.vo.Product;

/**
 * Servlet implementation class PayOrderServlet
 */
@WebServlet("/jsp/PayOrderServlet")
public class PayOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path ="buy.jsp";
		String orderno=request.getParameter("orderno");
		Order ord=new Order();
		Product book=new Product();
		try{
		ord=DAOFactory.getIOrderDAOInstance().findById(orderno);
		book=DAOFactory.getIProductDAOInstance().findById(ord.getBookId());
		}catch(Exception e){
			
		}
		Integer countFee=ord.getNum()*ord.getFee();
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
	}

}
