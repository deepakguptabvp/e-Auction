package com.cognizant.eauction.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bid")
public class Bid {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Product product;
	@ManyToOne
	private Buyer buyer;
	private int bidAmount;
	/**
	 * 
	 */
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
	@Override
	public String toString() {
		return "Bid [id=" + id + ", product=" + product + ", buyer=" + buyer + ", bidAmount=" + bidAmount + "]";
	}
	
	

}
