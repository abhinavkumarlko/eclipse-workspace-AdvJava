package beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Emp {
	
	int empno;
	Name name;
	@Autowired
	Address address;
	float salary;
	Dept dept;
	List<String> emails;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empno, Name name, Address address, float salary, Dept dept, List<String> emails) {
		super();
		this.empno = empno;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.dept = dept;
		this.emails = emails;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
//	@Autowired
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", address=" + address + ", salary=" + salary + ", dept="
				+ dept + ", emails=" + emails + "]";
	}
	
	
	
	
	
	
}
