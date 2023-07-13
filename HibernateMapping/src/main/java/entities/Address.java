package entities;

import javax.persistence.Column;

public class Address {

	@Column
	String area;
	
	@Column
	String city;
	
	@Column
	String pincode;
	
	
	public Address(String area, String city, String pincode) {
		super();
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}


	public Address() {
		super();
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
