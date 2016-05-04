package book.dao.proxy;

import java.util.List;

import java.util.Set;

import book.dao.IOrderDAO;
import book.dao.impl.OrderDAOImpl;
import book.dbc.DatabaseConnection;
import book.vo.Order;

public class OrderDAOProxy implements IOrderDAO {
	private DatabaseConnection dbc = null;
	private IOrderDAO dao = null;
	private long count = 0;
    private int page=0;
	public OrderDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new OrderDAOImpl(this.dbc.getConnection());
	}

	public void doUpdateCount(Integer id) throws Exception {
		try {
			this.dao.doUpdateCount(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public List<Order> findAll(Set<Integer> key) throws Exception {
		List<Order> all = null;
		try {
			all = this.dao.findAll(key);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean doCreate(Order vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doCreate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doRemove(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Order vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdate(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}
	public boolean doUpdateSth(Order vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.doUpdateSth(vo);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public List<Order> findAll(String keyWord) throws Exception {
		List<Order> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<Order> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<Order> all = null;
		try {
			all = this.dao.findAll(keyWord, currentPage, lineSize);
			this.count = this.dao.getAllCount(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Order findById(String id) throws Exception {
		Order pro = null;
		try {
			pro = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return pro;
	}

	public long getAllCount(String keyWord) throws Exception {
		return this.count;
	}
	
}
