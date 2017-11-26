package entity;

import java.sql.Date;

public class Message {
	private String uname;
	private String title;
	private String email;
	private Date mestime;
	private String content;
	private int id;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getMestime() {
		return mestime;
	}
	public void setMestime(Date mestime) {
		this.mestime = mestime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "message [id="+ ", title=" + title + ", email=" + email + ", mestime=" + mestime + ", content="
				+ content + "]";
	}
	
	
	
	
}
