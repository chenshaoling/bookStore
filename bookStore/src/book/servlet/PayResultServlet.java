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
 * Servlet implementation class PayResultServlet
 */
@WebServlet("/jsp/PayResultServlet")
public class PayResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8") ;
		String orderno=request.getParameter("orderno");
		String addno=request.getParameter("addno");
		Integer countFee=Integer.parseInt(request.getParameter("countFee"));
//		Order order=new Order();
//		order.setOrderState("´ý·¢»õ");
//		order.setOrderno(orderno);
//		order.setAddno(addno);
		String mid=request.getParameter("mid");
		Member mem=new Member();
		
		
		try{
			mem=DAOFactory.getIMemberDAOInstance().findById(mid);
			
			int money =mem.getMoney();
			
			if(money<countFee){
				response.setHeader("refresh","1;URL=pay_erro.jsp?orderno="+orderno+"&addno="+addno);
				
			}else{
				//if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
				response.setHeader("refresh","1;URL=pay_sub.jsp?orderno="+orderno+"&countFee="+countFee+"&addno="+addno);
				
					//path="pay_success.jsp";
					
				//}
			}
			
		}
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		//request.setAttribute("orderno", order);
		//request.getRequestDispatcher(path).forward(request,response) ;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
