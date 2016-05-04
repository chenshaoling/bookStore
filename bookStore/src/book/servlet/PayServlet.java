package book.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.DAOFactory;
import book.vo.Member;
import book.vo.Order;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/jsp/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ;
		String path="pay.jsp";
		String orderno=request.getParameter("orderno");
		String addno=request.getParameter("addno");
		Integer countFee=Integer.parseInt(request.getParameter("countFee"));
		Integer fee=Integer.parseInt(request.getParameter("fee"));
		
		Order order=new Order();
		order.setOrderState("Î´¸¶¿î");
		order.setAddno(addno);
		order.setOrderno(orderno);		
		try{					 
			if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
				path="pay.jsp";
			}
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		request.setAttribute("fee", fee);
        request.setAttribute("countFee", countFee);
        request.setAttribute("orderno", orderno);
        request.setAttribute("addno", addno);      		
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
