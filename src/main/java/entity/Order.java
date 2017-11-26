package entity;

public class Order {
	private String uname;
	private double price;
	private String address;
	private long phone;
	
	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public String getUname() {
		return uname;
	}
	
	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	@Override
	public String toString() {
		return "Order [uname=" + uname + ", price=" + price + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
