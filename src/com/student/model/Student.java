package com.student.model;

public class Student {
private int stid;
private String fname;
private String lname;
private int cid;

public Student() {
	// TODO Auto-generated constructor stub
}

public int getStid() {
	return stid;
}

public void setStid(int stid) {
	this.stid = stid;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public Student(int stid, String fname, String lname, int cid) {
	this.stid = stid;
	this.fname = fname;
	this.lname = lname;
	this.cid = cid;
}

@Override
public String toString() {
	return "Student [stid=" + stid + ", fname=" + fname + ", lname=" + lname + ", cid=" + cid + "]";
}

}
