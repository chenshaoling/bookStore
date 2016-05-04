package book.vo;

import java.io.Serializable;

public class AddressInfo implements Serializable {
	private String addno ;
	private String mid ;
	private String addname ;
	private String addr;
	private String phone;
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
	public String getAddname() {
		return addname;
	}
	public void setAddname(String addname) {
		this.addname = addname;
	}
	public  String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr= addr;
	}
	public  String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone= phone;
	}
	
}
