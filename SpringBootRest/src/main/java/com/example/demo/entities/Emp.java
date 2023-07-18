package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="emp")
public class Emp {
	
	@Id
	int empid;
	
	@Column
	String ename;
	
	@Column
	int deptno;
	
	@Column
	float salary;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	Date bdate;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empid, String ename, int deptno, float salary, Date bdate) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.deptno = deptno;
		this.salary = salary;
		this.bdate = bdate;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	
	
	
}
