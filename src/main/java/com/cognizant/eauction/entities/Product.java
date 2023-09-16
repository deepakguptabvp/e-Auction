package com.cognizant.eauction.entities;

import java.sql.Timestamp; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@ManyToOne 
	private ProductCategory category;
	@NotNull
	@Size(min = 5, max = 50)
	private String productName;  
	@NotNull
	private String shortDescription;
	@NotNull
	private String detailedDescription;
	@NotNull
	private int startingPrice;
	@Future
	private Timestamp bidEndDate;
	/** 
	 *   
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getshortDescription() {
		return shortDescription;
	}
	public void setshortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getdetailedDescription() {
		return detailedDescription;
	}
	public void setdetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public int getstartingPrice() {
		return startingPrice;
	}
	public void setstartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}
	public Timestamp getbidEndDate() {
		return bidEndDate;
	}
	public void setbidEndDate(Timestamp bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", shortDescription="
				+ shortDescription + ", detailedDescription=" + detailedDescription + ", startingPrice=" + startingPrice
				+ ", bidEndDate=" + bidEndDate + "]";
	}

	    
}