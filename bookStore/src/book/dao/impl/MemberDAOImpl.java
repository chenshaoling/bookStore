package book.dao.impl;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import book.dao.IMemberDAO;
import book.vo.Member;
import book.vo.Product;

public class MemberDAOImpl implements IMemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	public MemberDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateLastdate(String id) throws Exception {
		String sql = "UPDATE member SET lastdate=? WHERE mid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt
				.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
		this.pstmt.setString(2, id);
		this.pstmt.executeUpdate();
	}

	public boolean findLogin(Member vo) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(mid) FROM member WHERE mid=? AND password=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getPassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) > 0) {
				flag = true;
			}
		}
		return flag;
	}

	public boolean doCreate(Member vo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO member(mid,password,email,lastdate,paypassword,money) VALUES (?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getPassword());
		
		this.pstmt.setString(3, vo.getEmail());
		
		this.pstmt.setDate(4, new java.sql.Date(vo.getLastdate().getTime()));
		this.pstmt.setString(5, vo.getPaypassword());
		this.pstmt.setInt(6, vo.getMoney());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		throw new Exception("此方法未实现！");
	}

	public boolean doUpdate(Member vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE member SET money=? WHERE mid=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setLong(1, vo.getMoney());
		this.pstmt.setString(2, vo.getMid());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Member> findAll(String keyWord) throws Exception {
		throw new Exception("此方法未实现！");
	}

	public List<Member> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}

	public Member findById(String id) throws Exception {
		Member mem = null ;
		String sql = "SELECT mid,password,email,lastdate,paypassword,money FROM member WHERE mid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()){
			mem = new Member() ;
			mem.setMid(rs.getString(1)) ;
			mem.setPassword(rs.getString(2)) ;
			
			mem.setEmail(rs.getString(3)) ;
			
			mem.setLastdate(rs.getDate(4)) ;
			mem.setPaypassword(rs.getString(5)) ;
			mem.setMoney(rs.getInt(6)) ;
		}
		return mem;
	}

	public long getAllCount(String keyWord) throws Exception {
		throw new Exception("此方法未实现！");
	}
	public boolean findPaypass(Member vo) throws Exception {
		boolean flag = false;
		String sql = "SELECT COUNT(mid) FROM member WHERE mid=? AND paypassword=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getPaypassword());
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) > 0) {
				flag = true;
			}
		}
		return flag;
	}
	public int PageSize() throws Exception {
		int rowCount=0;
		String sql = "select count(*) from member ";
		this.pstmt = this.conn.prepareStatement(sql);
		//this.pstmt.setString(1, id) ;
		ResultSet rs = this.pstmt.executeQuery() ;
		 while(rs.next())  
         {  
             rowCount=rs.getInt(1);  //获取表中记录总数  
         }
		return rowCount;
	}
	public List<Member>  findPage(String keyWord) throws Exception {
		List<Member> all = new ArrayList<Member>();
	    int pageSize=3;  //希望每页显示记录的条数  
        int pageNow=1;   //初始化当前页为第一页  
        //String keyWord=null;
        String sql = "SELECT mid,password,email,lastdate,paypassword,money FROM member "+
				" WHERE mid LIKE ? OR password LIKE ? OR email LIKE ? OR lastdate like ? OR paypassword like ? OR money like ?" ; 
		
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery() ;
		
		if(rs.next()){
			Member mem = new Member() ;
			mem.setMid(rs.getString(1)) ;
			mem.setPassword(rs.getString(2)) ;
			
			mem.setEmail(rs.getString(3)) ;
			
			mem.setLastdate(rs.getDate(4)) ;
			mem.setPaypassword(rs.getString(5)) ;
			mem.setMoney(rs.getInt(6)) ;
			all.add(mem);
		}
		return all;
	}



	


	
	


}
