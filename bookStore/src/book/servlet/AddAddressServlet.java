package book.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.factory.DAOFactory;
import book.vo.AddressInfo;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/jsp/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		
		request.setCharacterEncoding("utf-8") ; 
	    String mid=request.getParameter("mid");
		String path ="BookInfoServlet?mid="+"\""+mid+"\"";
		String addname=request.getParameter("addname");
		String addr=request.getParameter("addr");
		String phone=request.getParameter("phone");
		
		AddressInfo address=new AddressInfo();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String addno = sdf.format(new java.sql.Date(new java.util.Date().getTime()))+mid;
		
		address.setAddno(addno);
		address.setMid(mid);
		address.setAddname(addname);
		address.setAddr(addr);
		address.setPhone(phone);
		
		try {
			if(DAOFactory.getIAddressInfoDAOInstance().doCreate(address)){
				 path ="BookInfoServlet?mid="+"\""+mid+"\"";
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("addname", address.getAddname());
		request.setAttribute("addr", address.getAddr());
		request.setAttribute("phone", address.getPhone());
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
