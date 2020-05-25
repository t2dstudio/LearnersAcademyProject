package com.subject.model;

public class Subject {
	private int scode;
	private String sname;
	private int cid;
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	public int getScode() {
		return scode;
	}
	public void setScode(int scode) {
		this.scode = scode;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Subject(int scode, String sname, int cid) {
		this.scode = scode;
		this.sname = sname;
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Subject [scode=" + scode + ", sname=" + sname + ", cid=" + cid + "]";
	}
	
	

}
