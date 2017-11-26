package entity;

import java.sql.Date;

public class Supper {
	private String uname;
	private String password;
	private int id;
	private String name;
	private String gender;
	private String department;
	private int age;
	private Date registDate;
	private Date lasttime;
	private int count;
	
	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Supper(){
		
	}
	
	public Supper(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pwd) {
		this.password = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", name=" + name + ", pwd=" + password +
				", gender=" + gender+ ", department=" + department + ", age=" + age + 
				", registDate=" + registDate + "]";
	}




}





