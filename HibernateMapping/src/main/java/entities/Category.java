package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int cid;
	
	@Column
	String cname;
	
	@Column
	String cdesc;
	
	@OneToMany(mappedBy = "cat")
	@Cascade(value = CascadeType.ALL)
	Set<Product> items;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Category(String cname, String cdesc, Set<Product> items) {
		super();
		
		this.cname = cname;
		this.cdesc = cdesc;
		for(Product p : items)
			p.setCat(this);
		this.items = items;
	}
	
	


	public Category(String cname, String cdesc) {
		super();
		this.cname = cname;
		this.cdesc = cdesc;
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Product> getItems() {
		return items;
	}

	public void setItems(Set<Product> items) {
		this.items = items;
	}
	
}
