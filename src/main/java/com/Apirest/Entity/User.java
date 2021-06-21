package com.Apirest.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Users")
public class User {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="lastLogin")
	@CreationTimestamp
	private Date lastLogin;
	
	@Column(name="birthday")
	private Date birthday;
	
	//default constructor
	public User() {}
	
	//Constructor for basic props
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	//getter and setter for id
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//getter and setter for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//getter and setter for email
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//getter and setter for password (this is gonna be changed)
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//getter and setter for username
	public String getUsername() {
		return this.userName;
	}
	public void getUsername(String userName) {
		this.userName = userName;
	}
	//getter and setter for phone number
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//getter and setter for lastLogin
	public Date getLastLogin() {
		return this.lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	//getter and setter for birthday
	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
