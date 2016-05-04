package book.vo;

import java.io.Serializable;

public class Order implements Serializable {
	private String orderno ;
	private String bookId ;
	private String addno ;
	private String mid ;
	private String orderState ;
	private Integer fee;
	private Integer num;
	private String time;
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getAddno() {
		return addno;
	}
	public void setAddno(String addno) {
		this.addno = addno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public  Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee= fee;
	}
	public  Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num= num;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
