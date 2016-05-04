package book.dao.impl;
import java.io.*;



import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import book.dao.IAddressInfoDAO;
import book.vo.AddressInfo;

public class AddressInfoDAOImpl implements IAddressInfoDAO {
	private Connection conn;
	private PreparedStatement pstmt = null;

	public AddressInfoDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateCount(Integer id) throws Exception {
		String sql = "UPDATE addressinfo SET count=count+1 WHERE addno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		this.pstmt.executeUpdate();
	}

	public List<AddressInfo> findAll(Set<Integer> key) throws Exception {
		List<AddressInfo> all = new ArrayList<AddressInfo>();
		StringBuffer sql = new StringBuffer(); // 循环修改内容的时候使用StringBuffer
		sql
				.append("SELECT addno,mid,addname,addr,phone FROM addressinfo WHERE addno IN (");
		int count = 0;
		Iterator<Integer> iter = key.iterator();
		while (iter.hasNext()) {
			count++;
			sql.append(iter.next());
			if (count <= key.size() - 1) {
				sql.append(",");
			}
		}
		sql.append(")");
		this.pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			AddressInfo addr = new AddressInfo();
			addr.setAddno(rs.getString(1));
			addr.setMid(rs.getString(2));
			addr.setAddname(rs.getString(3));
			addr.setAddr(rs.getString(4));
			addr.setPhone(rs.getString(5));
			
		}
		return all;
	}

	public boolean doCreate(AddressInfo vo) throws Exception {
		boolean flag = false;
		//PrintWriter out=response.getWriter();
	   
		String sql = "INSERT INTO addressinfo(addno,mid,addname,addr,phone)"
				+ " VALUES (?,?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getAddno());
		this.pstmt.setString(2, vo.getMid());
		this.pstmt.setString(3, vo.getAddname());
		this.pstmt.setString(4, vo.getAddr());
		this.pstmt.setString(5, vo.getPhone());
		
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM addressinfo WHERE addno=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doUpdate(AddressInfo vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE addressinfo SET mid=?,addname=?,addr=?,phone=?  WHERE addno=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(5, vo.getAddno());
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getAddname());
		this.pstmt.setString(3, vo.getAddr());
		this.pstmt.setString(4, vo.getPhone());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<AddressInfo> findAll(String keyWord) throws Exception {
		List<AddressInfo> all = new ArrayList<AddressInfo>();
		String sql = "SELECT addno,mid,addname,addr,phone"
				+ " FROM addressinfo WHERE mid LIKE ? OR addname LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			AddressInfo addr = new AddressInfo();
			addr.setAddno(rs.getString(1));
			addr.setMid(rs.getString(2));
			addr.setAddname(rs.getString(3));
			addr.setAddr(rs.getString(4));
			addr.setPhone(rs.getString(5));
			
			all.add(addr);
		}
		return all;
	}



	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		String sql = "SELECT COUNT(orderno) FROM book_order "
				+ "  WHERE orderState LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) { // 取得全部的记录数
			count = rs.getInt(1);
		}
		return count;
	}
	public List<AddressInfo> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}
	public AddressInfo findById(String id) throws Exception {
		AddressInfo addr = null;
		String sql = "SELECT addno,mid,addname,addr,phone  FROM addressinfo WHERE addno=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			addr = new AddressInfo();
			addr.setAddno(rs.getString(1));
			addr.setMid(rs.getString(2));
			addr.setAddname(rs.getString(3));
			addr.setAddr(rs.getString(4));
			addr.setPhone(rs.getString(5));
			
		}
		return addr ;
	}
	

}
