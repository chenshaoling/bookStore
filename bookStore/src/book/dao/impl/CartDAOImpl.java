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

import book.dao.ICartDAO;
import book.vo.Cart;

public class CartDAOImpl implements ICartDAO{
	private Connection conn;
	private PreparedStatement pstmt = null;

	public CartDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateCount(Integer id) throws Exception {
		String sql = "UPDATE cart SET count=count+1 WHERE cartid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		this.pstmt.executeUpdate();
	}

	public List<Cart> findAll(Set<Integer> key) throws Exception {
		List<Cart> all = new ArrayList<Cart>();
		StringBuffer sql = new StringBuffer(); // 循环修改内容的时候使用StringBuffer
		sql
				.append("SELECT cartid,bookId,mid,counts,fee FROM cart WHERE cartid IN (");
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
			Cart cart = new Cart();
			cart.setCartid(rs.getString(1));
			cart.setBookId(rs.getString(2));
			cart.setMid(rs.getString(3));
			cart.setCounts(rs.getInt(4));
			cart.setFee(rs.getInt(5));
			
		}
		return all;
	}

	public boolean doCreate(Cart vo) throws Exception {
		boolean flag = false;
		//PrintWriter out=response.getWriter();
	   
		String sql = "INSERT INTO cart(cartid,bookId,mid,counts,fee)"
				+ " VALUES (?,?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getCartid());
		this.pstmt.setString(2, vo.getBookId());
		this.pstmt.setString(3, vo.getMid());
		this.pstmt.setInt(4, vo.getCounts());
		this.pstmt.setInt(5, vo.getFee());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM cart WHERE cartid=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doUpdate(Cart vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE cart SET bookId=?.mid=?,counts=?,fee=?  WHERE cartid=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(5, vo.getCartid());
		this.pstmt.setString(1, vo.getBookId());
		this.pstmt.setString(2, vo.getMid());
		this.pstmt.setInt(3, vo.getCounts());
		this.pstmt.setInt(4, vo.getFee());
		
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Cart> findAll(String keyWord) throws Exception {
		List<Cart> all = new ArrayList<Cart>();
		String sql = "SELECT cartid,bookId,mid,counts,fee"
				+ " FROM cart WHERE mid = ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,  keyWord );
	
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Cart cart = new Cart();
			cart.setCartid(rs.getString(1));
			cart.setBookId(rs.getString(2));
			cart.setMid(rs.getString(3));
			cart.setCounts(rs.getInt(4));
			cart.setFee(rs.getInt(5));
			
			all.add(cart);
		}
		return all;
	}



	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		String sql = "SELECT COUNT(cartid) FROM cart "
				+ "  WHERE mid LIKE ?  ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) { // 取得全部的记录数
			count = rs.getInt(1);
		}
		return count;
	}
	public List<Cart> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}
	public Cart findById(String id) throws Exception {
		Cart cart = null;
		String sql = "SELECT cartid,bookId,mid,counts,fee  FROM cart WHERE cartid=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			cart = new Cart();
			cart.setCartid(rs.getString(1));
			cart.setBookId(rs.getString(2));
			cart.setMid(rs.getString(3));
			cart.setCounts(rs.getInt(4));
			cart.setFee(rs.getInt(5));
			
		}
		return cart ;
	}
	

}
