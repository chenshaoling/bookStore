package book.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.* ;
import book.vo.* ;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/jsp/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member mem = new Member() ;
	    String re_mid=request.getParameter("mid");
	    String re_pass=request.getParameter("password");
	    String re_email=request.getParameter("email");
		mem.setMid(re_mid) ;
		mem.setPassword(re_pass) ;
		mem.setEmail(re_email) ;
		mem.setPaypassword(re_pass);
		mem.setLastdate(new java.util.Date()) ;
		mem.setMoney(200);
		try{
			if(DAOFactory.getIMemberDAOInstance().doCreate(mem)){	// ע��ɹ�
				response.setHeader("refresh","2;URL=index.jsp") ;
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
				
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>��ϲ"+mem.getMid()+"�û�ע��ɹ����������ת����ҳ���е�½������</h3>");
				out.println("<h3>���û����ת���밴 <a href='index.jsp'>����</a>��</h3>");
				out.println("</body>");
				out.println("</html>");
				out.close();
		   }else if(re_mid==null){
			   response.setContentType("text/html;charset=utf-8");
		   }else{
			   response.setHeader("refresh","2;URL=index.jsp") ;
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out=response.getWriter();
			
				out.println("<script>");
				out.println("alert('�û�ע��ʧ�ܣ���ע��ID�Ѿ�����ʹ���ˣ�');");
				out.println("</script>");
				out.close();
		   }
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request,response) ;
	}

}
