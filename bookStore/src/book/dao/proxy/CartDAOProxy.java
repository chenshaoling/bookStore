package book.dao.proxy;

import java.util.List;

import java.util.Set;

import book.dao.ICartDAO;
import book.dao.impl.CartDAOImpl;
import book.dbc.DatabaseConnection;
import book.vo.Cart;

public class CartDAOProxy implements ICartDAO {
	private DatabaseConnection dbc = null;
	private ICartDAO dao = null;
	private long count = 0;
    private int page=0;
	public CartDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new CartDAOImpl(this.dbc.getConnection());
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

	public List<Cart> findAll(Set<Integer> key) throws Exception {
		List<Cart> all = null;
		try {
			all = this.dao.findAll(key);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean doCreate(Cart vo) throws Exception {
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

	public boolean doUpdate(Cart vo) throws Exception {
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

	public List<Cart> findAll(String keyWord) throws Exception {
		List<Cart> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<Cart> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<Cart> all = null;
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

	public Cart findById(String id) throws Exception {
		Cart cart = null;
		try {
			cart = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return cart;
	}

	public long getAllCount(String keyWord) throws Exception {
		return this.count;
	}
	
}
