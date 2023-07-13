package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="permemp")
@PrimaryKeyJoinColumn(name="empid")
public class PermanentEmp extends Emp {

	@Column
	float allowances;
	@Column
	float bonus;
	@Column
	float deductions;
	
	public PermanentEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermanentEmp(int id, String name, String email, String contactno, float basic, float allowances, float bonus,
			float deductions) {
		super(id, name, email, contactno, basic);
		this.allowances = allowances;
		this.bonus = bonus;
		this.deductions = deductions;
	}

	public float getAllowances() {
		return allowances;
	}

	public void setAllowances(float allowances) {
		this.allowances = allowances;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public float getDeductions() {
		return deductions;
	}

	public void setDeductions(float deductions) {
		this.deductions = deductions;
	}

	
	

}
