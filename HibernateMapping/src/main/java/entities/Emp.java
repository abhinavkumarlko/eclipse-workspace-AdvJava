package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@Inheritance(strategy = InheritanceType.JOINED)
public class Emp {
	
	@Id
	int id;
	
	@Column
	String name;
	
	@Column
	String email;
	
	@Column
	String contactno;
	
	@Column
	float basic;
	
	
	public Emp() {
		super();
	}


	public Emp(int id, String name, String email, String contactno, float basic) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.basic = basic;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public float getBasic() {
		return basic;
	}


	public void setBasic(float basic) {
		this.basic = basic;
	}
	

}
