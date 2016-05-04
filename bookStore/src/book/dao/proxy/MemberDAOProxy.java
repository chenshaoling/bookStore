package book.dao.proxy;

import java.util.List;







import book.dao.IMemberDAO;
import book.dao.impl.MemberDAOImpl;
import book.dbc.DatabaseConnection;
import book.vo.Member;
import book.vo.Product;

public class MemberDAOProxy implements IMemberDAO {

	private DatabaseConnection dbc = null;
	private IMemberDAO dao;

	public MemberDAOProxy() throws Exception{
              

		this.dbc = new DatabaseConnection();
               
		this.dao = new MemberDAOImpl(this.dbc.getConnection());
	}

	public void doUpdateLastdate(String id) throws Exception {
		try {
			this.dao.doUpdateLastdate(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public boolean findLogin(Member vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(vo);
			if (flag) { // 用户登陆成功
				this.dao.doUpdateLastdate(vo.getMid()); // 更新用户的最后一次登陆时间
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doCreate(Member vo) throws Exception {
		boolean flag = false;
		try {
			if (this.dao.findById(vo.getMid()) == null) {
				flag = this.dao.doCreate(vo);
			}
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

	public boolean doUpdate(Member vo) throws Exception {
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

	public List<Member> findAll(String keyWord) throws Exception {
		List<Member> all = null;
		try {
			all = this.dao.findAll(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public List<Member> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		List<Member> all = null;
		try {
			all = this.dao.findAll(keyWord, currentPage, lineSize);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public Member findById(String id) throws Exception {
		Member mem = null;
		try {
			mem = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return mem;
	}

	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		try {
			count = this.dao.getAllCount(keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return count;
	}
	public boolean findPaypass(Member vo) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findPaypass(vo);
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public int PageSize() throws Exception {
		// TODO Auto-generated method stub
		int rowCount = 0;
		try {
			rowCount = this.dao.PageSize();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return rowCount;
	}

	@Override
	public List<Member> findPage(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<Member> all = null;
		try {
			all = this.dao.findPage( keyWord);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
