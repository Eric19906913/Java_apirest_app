package com.Apirest.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Sells")
public class Sell {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
	private int id;
	
	@Column(name="quantity")
	private long quantity;
	
	@Column(name="type")
	private String type;
	
	@Column(name="total")
	private long total;
	
	@Column(name="publishDate")
	@CreationTimestamp
	private Date publishDate;
	
	@Column(name="deliveryDate")
	private Date deliverDate;
	
	@ManyToMany
	private List<Product> products;
}
