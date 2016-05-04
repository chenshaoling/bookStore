package book.dao.proxy;

import java.util.List;


import java.util.Set;

import book.dao.IProductDAO;
import book.dao.impl.ProductDAOImpl;
import book.dbc.DatabaseConnection;
import book.vo.Product;

public class ProductDAOProxy implements IProductDAO {
	private DatabaseConnection dbc = null;
	private IProductDAO dao = null;
	private long count = 0;
    private int page=0;
	public ProductDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new ProductDAOImpl(this.dbc.getConnection());
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

	public List<Product> findAll(Set<Integer> key) throws Exception {
		List<Product> all = null;
		try {
			all = this.dao.findAll(key);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean doCreate(Product vo) throws Exception {
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

	public boolean doUpdate(Product vo) throws Exception {
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

	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<Product> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<Product> all = null;
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

	public Product findById(String id) throws Exception {
		Product pro = null;
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
	public List<Product> findByType(String keyWord) throws Exception {
		List<Product> all = null;
		try {
			all = this.dao.findByType(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}
	
}
