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

import book.dao.IProductDAO;
import book.vo.Product;

public class ProductDAOImpl implements IProductDAO {
	private Connection conn;
	private PreparedStatement pstmt = null;

	public ProductDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public void doUpdateCount(Integer id) throws Exception {
		String sql = "UPDATE book SET count=count+1 WHERE bookId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		this.pstmt.executeUpdate();
	}

	public List<Product> findAll(Set<Integer> key) throws Exception {
		List<Product> all = new ArrayList<Product>();
		StringBuffer sql = new StringBuffer(); // 循环修改内容的时候使用StringBuffer
		sql
				.append("SELECT bookId,book_type,bookName,bookImg,author,publishing,introduct ,price,new_price,onsaleDate,catalog,num FROM book WHERE bookId IN (");
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
			Product pro = new Product();
			pro.setBookId(rs.getString(1));
			pro.setBook_type(rs.getString(2));
			pro.setBookName(rs.getString(3));
			pro.setBookImg(rs.getString(4));
			pro.setAuthor(rs.getString(5));
			pro.setPublishing(rs.getString(6));
			pro.setIntroduct(rs.getString(7));
			pro.setPrice(rs.getInt(8));
			pro.setNew_price(rs.getInt(9));
			pro.setOnsaleDate(rs.getDate(10));
			pro.setCatalog(rs.getString(11));
			pro.setNum(rs.getInt(12));
			all.add(pro);
		}
		return all;
	}

	public boolean doCreate(Product vo) throws Exception {
		boolean flag = false;
		//PrintWriter out=response.getWriter();
	   
		String sql = "INSERT INTO book(bookId,book_type,bookName,bookImg,author,publishing,introduct ,price,new_price,onsaleDate,catalog,num)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getBookId());
		this.pstmt.setString(2, vo.getBook_type());
		this.pstmt.setString(3, vo.getBookName());
		this.pstmt.setString(4, vo.getBookImg());
		this.pstmt.setString(5, vo.getAuthor());
		this.pstmt.setString(6 ,vo.getPublishing());
		this.pstmt.setString(7, vo.getIntroduct());
		this.pstmt.setInt(8, vo.getPrice());
		this.pstmt.setInt(9, vo.getNew_price());
		this.pstmt.setDate(10, new java.sql.Date(vo.getOnsaleDate().getTime()));
		this.pstmt.setString(11, vo.getCatalog());
		this.pstmt.setInt(12, vo.getNum());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doRemove(String id) throws Exception {
		boolean flag = false;
		String sql = "DELETE FROM book WHERE bookId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public boolean doUpdate(Product vo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE book SET book_type=?,bookName=?,bookImg=?,author=?,publishing=?,introduct=? ,price=?,new_price=?,onsaleDate=?,catalog=?,num=? WHERE bookId=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(12, vo.getBookId());
		this.pstmt.setString(1, vo.getBook_type());
		this.pstmt.setString(2, vo.getBookName());
		this.pstmt.setString(3, vo.getBookImg());
		this.pstmt.setString(4, vo.getAuthor());
		this.pstmt.setString(5, vo.getPublishing());
		this.pstmt.setString(6, vo.getIntroduct());
		this.pstmt.setInt(7, vo.getPrice());
		this.pstmt.setInt(8, vo.getNew_price());
		this.pstmt.setDate(9, new java.sql.Date(vo.getOnsaleDate().getTime()));
		this.pstmt.setString(10, vo.getCatalog());
		this.pstmt.setInt(11, vo.getNum());
		if (this.pstmt.executeUpdate() > 0) {
			flag = true;
		}
		return flag;
	}

	public List<Product> findAll(String keyWord) throws Exception {
		List<Product> all = new ArrayList<Product>();
		String sql = "SELECT bookId,book_type,bookName,bookImg,author,publishing,introduct ,price,new_price,onsaleDate,catalog,num"
				+ " FROM book WHERE book_type LIKE ? OR bookName LIKE ? OR author LIKE ? OR publishing LIKE ? OR price LIKE ? OR onsaleDate LIKE ? order by bookId desc";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord + "%");
		this.pstmt.setString(2, "%" + keyWord + "%");
		this.pstmt.setString(3, "%" + keyWord + "%");
		this.pstmt.setString(4, "%" + keyWord + "%");
		this.pstmt.setString(5, "%" + keyWord + "%");
		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Product pro = new Product();
			pro.setBookId(rs.getString(1));
			pro.setBook_type(rs.getString(2));
			pro.setBookName(rs.getString(3));
			pro.setBookImg(rs.getString(4));
			pro.setAuthor(rs.getString(5));
			pro.setPublishing(rs.getString(6));
			pro.setIntroduct(rs.getString(7));
			pro.setPrice(rs.getInt(8));
			pro.setNew_price(rs.getInt(9));
			pro.setOnsaleDate(rs.getDate(10));
			pro.setCatalog(rs.getString(11));
			pro.setNum(rs.getInt(12));
			all.add(pro);
		}
		return all;
	}



	public long getAllCount(String keyWord) throws Exception {
		long count = 0;
		String sql = "SELECT COUNT(bookId) FROM book ";
//				+ "  WHERE bookId LIKE ? OR book_type LIKE ? OR bookName LIKE ? OR author LIKE ? OR publishing LIKE ? OR price LIKE ? OR onsaleDate LIKE ? ";
//		this.pstmt = this.conn.prepareStatement(sql);
//		this.pstmt.setString(1, "%" + keyWord + "%");
//		this.pstmt.setString(1, "%" + keyWord + "%");
//		this.pstmt.setString(2, "%" + keyWord + "%");
//		this.pstmt.setString(3, "%" + keyWord + "%");
//		this.pstmt.setString(4, "%" + keyWord + "%");
//		this.pstmt.setString(5, "%" + keyWord + "%");
//		this.pstmt.setString(6, "%" + keyWord + "%");
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) { // 取得全部的记录数
			count = rs.getInt(1);
		}
		return count;
	}
	public List<Product> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		throw new Exception("此方法未实现！");
	}
	public Product findById(String id) throws Exception {
		Product pro = null;
		String sql = "SELECT bookId,book_type,bookName,bookImg,author,publishing,introduct ,price,new_price,onsaleDate,catalog,num FROM book WHERE bookId=?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			pro = new Product();
			pro.setBookId(rs.getString(1));
			pro.setBook_type(rs.getString(2));
			pro.setBookName(rs.getString(3));
			pro.setBookImg(rs.getString(4));
			pro.setAuthor(rs.getString(5));
			pro.setPublishing(rs.getString(6));
			pro.setIntroduct(rs.getString(7));
			pro.setPrice(rs.getInt(8));
			pro.setNew_price(rs.getInt(9));
			pro.setOnsaleDate(rs.getDate(10));
			pro.setCatalog(rs.getString(11));
			pro.setNum(rs.getInt(12));
		}
		return pro;
	}
	public List<Product> findByType(String keyWord) throws Exception {
		List<Product> all = new ArrayList<Product>();
		String sql = "SELECT bookId,book_type,bookName,bookImg,author,publishing,introduct ,price,new_price,onsaleDate,catalog,num"
				+ " FROM book WHERE book_type LIKE ? order by bookId desc";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%" + keyWord+ "%");
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Product pro = new Product();
			pro.setBookId(rs.getString(1));
			pro.setBook_type(rs.getString(2));
			pro.setBookName(rs.getString(3));
			pro.setBookImg(rs.getString(4));
			pro.setAuthor(rs.getString(5));
			pro.setPublishing(rs.getString(6));
			pro.setIntroduct(rs.getString(7));
			pro.setPrice(rs.getInt(8));
			pro.setNew_price(rs.getInt(9));
			pro.setOnsaleDate(rs.getDate(10));
			pro.setCatalog(rs.getString(11));
			pro.setNum(rs.getInt(12));
			all.add(pro);
		}
		return all;
	}



}
