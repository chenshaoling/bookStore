package book.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.vo.Cart;
import book.vo.Product;
import book.factory.DAOFactory;
/**
 * Servlet implementation class AddInCartServlet
 */
@WebServlet("/jsp/AddInCartServlet")
public class AddInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //转码
		PrintWriter out=response.getWriter();
		String bookId=request.getParameter("bookId");
		String  mid=request.getParameter("id");
		Integer counts=Integer.parseInt(request.getParameter("chooseNum"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String cartid = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+mid;
		Product book =new Product();
		book.setBookId(bookId);
		out.println("</script>");
		try{
			book=DAOFactory.getIProductDAOInstance().findById(bookId);
			Integer fee=(book.getNew_price()>0?book.getNew_price():book.getPrice());
			Cart cart=new Cart();
			cart.setBookId(bookId);
			cart.setCartid(cartid);
			cart.setCounts(counts);
			cart.setFee(fee);
			cart.setMid(mid);
			
			if(DAOFactory.getICartDAOInstance().doCreate(cart)){
				 //out.println("<%=book.getCount()%>");
			   out.println("<script>");
			  out.println("alert('成功添加商品入购物车！');");
			  out.println("history.back();");
			  
			  out.println("</script>");
				  
				//response.setHeader("refresh","0;URL=book-info.jsp" );
			}
		}catch(Exception e){
			e.printStackTrace();
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
