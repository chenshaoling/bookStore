package book.dao.proxy;

import java.util.List;

import java.util.Set;

import book.dao.IAddressInfoDAO;
import book.dao.impl.AddressInfoDAOImpl;
import book.dbc.DatabaseConnection;
import book.vo.AddressInfo;

public class AddressInfoDAOProxy implements IAddressInfoDAO {
	private DatabaseConnection dbc = null;
	private IAddressInfoDAO dao = null;
	private long count = 0;
    private int page=0;
	public AddressInfoDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();
		this.dao = new AddressInfoDAOImpl(this.dbc.getConnection());
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

	public List<AddressInfo> findAll(Set<Integer> key) throws Exception {
		List<AddressInfo> all = null;
		try {
			all = this.dao.findAll(key);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean doCreate(AddressInfo vo) throws Exception {
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

	public boolean doUpdate(AddressInfo vo) throws Exception {
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

	public List<AddressInfo> findAll(String keyWord) throws Exception {
		List<AddressInfo> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<AddressInfo> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<AddressInfo> all = null;
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

	public AddressInfo findById(String id) throws Exception {
		AddressInfo pro = null;
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
