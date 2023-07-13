package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tempemp")
@PrimaryKeyJoinColumn(name="empid")
public class TemporaryEmp extends Emp {
	
	@Column
	float extrapay;
	@Column
	float taxes;
	public TemporaryEmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TemporaryEmp(int id, String name, String email, String contactno, float basic, float extrapay, float taxes) {
		super(id, name, email, contactno, basic);
		this.extrapay = extrapay;
		this.taxes = taxes;
	}
	public float getExtrapay() {
		return extrapay;
	}
	public void setExtrapay(float extrapay) {
		this.extrapay = extrapay;
	}
	public float getTaxes() {
		return taxes;
	}
	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}
	
	
	

}
