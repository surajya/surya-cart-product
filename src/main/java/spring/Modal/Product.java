package spring.Modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String pName;

	@Column(length = 3000)
	private String pDiscription;
	private long pPrice;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDiscription() {
		return pDiscription;
	}
	public void setpDiscription(String pDiscription) {
		this.pDiscription = pDiscription;
	}
	public long getpPrice() {
		return pPrice;
	}
	public void setpPrice(long pPrice) {
		this.pPrice = pPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pId, String pName, String pDiscription, long pPrice) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDiscription = pDiscription;
		this.pPrice = pPrice;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDiscription="
				+ pDiscription + ", pPrice=" + pPrice + "]";
	}

}
