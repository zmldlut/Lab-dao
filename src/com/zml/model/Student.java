package com.zml.model;

public class Student {
	
	private String stdnum = null;
	private String cardID = null;
	private String name = null;
	private String password = null;
	private int major_id = -1;
	private int grade_id = -1;
	private String phone = null;
	private String email = null;
	private String QQ = null;
	private boolean is_here = false;
	
	public String getStdnum() {
		return stdnum;
	}
	public void setStdnum(String stdnum) {
		this.stdnum = stdnum;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	public int getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String QQ) {
		this.QQ = QQ;
	}
	public boolean getIs_here() {
		return is_here;
	}
	public void setIs_here(boolean is_here) {
		this.is_here = is_here;
	}
}
