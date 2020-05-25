package com.teacher.model;

public class Teacher {
	private int empid;
	private int scode;
	private String fname;
	private String lname;
	
public Teacher() {
	// TODO Auto-generated constructor stub
}

public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}

public int getScode() {
	return scode;
}

public void setScode(int scode) {
	this.scode = scode;
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

public Teacher(int empid, int scode, String fname, String lname) {
	this.empid = empid;
	this.scode = scode;
	this.fname = fname;
	this.lname = lname;
}

@Override
public String toString() {
	return "Teacher [empid=" + empid + ", scode=" + scode + ", fname=" + fname + ", lname=" + lname + "]";
}


}
