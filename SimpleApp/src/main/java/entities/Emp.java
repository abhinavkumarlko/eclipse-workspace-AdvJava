package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="emptemp") //name references to database
@NamedQuery(name="getBySal",query = "select empno,ename from Emp where sal > :min and sal < :max")

public class Emp {
	@Id
	@Column(name="empno") //name references to database table
	private int empno;
	
	@Column
	private String ename;
	
	@Column
	private float sal;
	
	@Column
	private int deptno;
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empid, String ename, float sal, int deptno) {
		super();
		this.empno = empid;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
	}
	
	public int getEmpid() {
		return empno;
	}
	public void setEmpid(int empid) {
		this.empno = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
