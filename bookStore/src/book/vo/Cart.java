package book.vo;

import java.io.Serializable;

public class Cart implements Serializable {
	private String cartid ;
	private String bookId ;
	private String mid ;
	private Integer counts ;
	private Integer fee;
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public  Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee= fee;
	}
	
}
