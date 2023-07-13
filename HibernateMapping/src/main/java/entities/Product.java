package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	
	@Column
	String name;
	
	@Column
	int price;
	
	@ManyToOne
	@JoinColumn(name="cid")
	//property mapped with FK column
	//datatype - master entity
	Category cat;
	
	
	public Product() {
		super();
	}


	public Product( String name, int price, Category cat) {
		super();
		
		this.name = name;
		this.price = price;
		this.cat = cat;
	}


	public Product( String name, int price) {
		super();
		
		this.name = name;
		this.price = price;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Category getCat() {
		return cat;
	}


	public void setCat(Category cat) {
		this.cat = cat;
	}
	
	
	
	
	

}
