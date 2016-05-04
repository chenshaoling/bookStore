package book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.DAOFactory;
import book.vo.Member;
import book.vo.Order;

/**
 * Servlet implementation class PayPasswordServlet
 */
@WebServlet("/jsp/PayPasswordServlet")
public class PayPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); //×ªÂë
		PrintWriter out=response.getWriter();
		String mid=request.getParameter("mid");
		String paypassword=request.getParameter("paypassword");
		String orderno=request.getParameter("orderno");
		String addno=request.getParameter("addno");
		Member mem=new Member();
		mem.setMid(mid);
		mem.setPaypassword(paypassword);
		
		Order order=new Order();
		order.setOrderState("´ý·¢»õ");
		order.setOrderno(orderno);
		order.setAddno(addno);
		try{
			mem=DAOFactory.getIMemberDAOInstance().findById(mid);
			order=DAOFactory.getIOrderDAOInstance().findById(orderno);
			int money =mem.getMoney();
			int ordermoney=order.getFee()*order.getNum();
		
				if(DAOFactory.getIMemberDAOInstance().findPaypass(mem)&&DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					//if(DAOFactory.getIOrderDAOInstance().doUpdateSth(order)){
					money=mem.getMoney()-order.getFee()*order.getNum();
					
					mem.setMoney(money);
					
					if(DAOFactory.getIMemberDAOInstance().doUpdate(mem)){
						response.setHeader("refresh","0;URL=pay_success.jsp?orderno="+orderno);
					}
					
					
			     }
				else{
					out.println("<script>");
					out.println("alert('Ö§¸¶Ê§°Ü£¬Ö§¸¶ÃÜÂë´íÎó£¡');");
					out.println("history.back();");
					out.println("</script>");
				}
			
			//	}
			
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
		this.doGet(request, response);
	}

}
