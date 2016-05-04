package book.factory ;
import book.dao.IMemberDAO;



import book.dao.proxy.MemberDAOProxy;

import book.dao.IEmpDAO;
import book.dao.proxy.EmpDAOProxy;
import book.dao.IProductDAO;
import book.dao.proxy.ProductDAOProxy;
import book.dao.IOrderDAO;
import book.dao.proxy.OrderDAOProxy;
import book.dao.ICartDAO;
import book.dao.proxy.CartDAOProxy;
import book.dao.IAddressInfoDAO;
import book.dao.proxy.AddressInfoDAOProxy;

public class DAOFactory {
	public static IEmpDAO getIEmpDAOInstance() throws Exception{
		return new EmpDAOProxy() ;
	}
	public static IMemberDAO getIMemberDAOInstance() throws Exception{
		return new MemberDAOProxy() ; 
	}
	public static IProductDAO getIProductDAOInstance() throws Exception{
		return new ProductDAOProxy() ;
	}
	public static IOrderDAO getIOrderDAOInstance() throws Exception{
		return new OrderDAOProxy() ;
	}
	public static ICartDAO getICartDAOInstance() throws Exception{
		return new CartDAOProxy() ;
	}
	public static IAddressInfoDAO getIAddressInfoDAOInstance() throws Exception{
		return new AddressInfoDAOProxy() ;
	}
}