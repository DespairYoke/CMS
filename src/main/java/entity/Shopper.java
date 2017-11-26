package entity;

public class Shopper {
	private String uname; //姓名
	private String pwd;  //密码
	private String gender;  //性别
	private long phone;   //电话
	private String address;  //地址
	private long cardnum;   //卡号
	public Shopper(String uname, String pwd) {
		this.uname=uname;
		this.pwd=pwd;
	}
	public Shopper() {
		
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCardnum() {
		return cardnum;
	}
	public void setCardnum(long cardnum) {
		this.cardnum = cardnum;
	}
	@Override
	public String toString() {
		return "Shopper [uname=" + uname + ", pwd=" + pwd + ", gender=" + gender +
				", phone=" + phone + ", address="
				+ address + ", cardnum=" + cardnum + "]";
	}
	
	
}
