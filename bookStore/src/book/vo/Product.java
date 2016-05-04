package book.vo;

import java.io.Serializable;

import java.util.Date;
public class Product implements Serializable {
	private String bookId ;
	private String book_type ;
	private String bookName ;
	private String author ;
	private String publishing ;
	private String introduct ;
	private String bookImg ;
	private Integer price;
	private Integer new_price;
	private Date onsaleDate;
	private String catalog;
	private Integer num;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBook_type() {
		return book_type;
	}
	public void setBook_type(String book_type) {
		this.book_type = book_type;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing= publishing;
	}
	public String getIntroduct() {
		return introduct;
	}
	public void setIntroduct(String introduct) {
		this.introduct = introduct;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price= price;
	}
	public Integer getNew_price() {
		return new_price;
	}
	public void setNew_price(Integer new_price) {
		this.new_price = new_price;
	}
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public Date getOnsaleDate() {
		return onsaleDate;
	}
	public void setOnsaleDate(Date onsaleDate) {
		this.onsaleDate = onsaleDate;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num= num;
	}
}
