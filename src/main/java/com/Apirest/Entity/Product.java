package com.Apirest.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="desciption")
	private String description;
	
	@Column(name="price")
	private float price;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="dischargeDate")
	@CreationTimestamp
	private Date dischargeDate;
	
	@ManyToMany
	private List<Sell> sells;
	
	// default constructor
	public Product() {}
	
	// Constructor for basic props
	public Product(int id, String name, String description, float price, int stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
}
