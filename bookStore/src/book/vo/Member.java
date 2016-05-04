package book.vo;

import java.io.Serializable;



import java.util.Date;

public class Member implements Serializable {
	private String mid ;
	private String password ;
	
	private String email ;
	
	private Date lastdate ;
	private String paypassword;
	private Integer money;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getPaypassword() {
		return paypassword;
	}
	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
