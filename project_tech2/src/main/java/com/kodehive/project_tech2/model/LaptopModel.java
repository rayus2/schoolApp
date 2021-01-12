package com.kodehive.project_tech2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="T_Laptop")
public class LaptopModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="merk")
	private String merk;
	
	@Column(name="seri_laptop")
	private String serialLaptop;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	public String getSerialLaptop() {
		return serialLaptop;
	}
	public void setSerialLaptop(String serialLaptop) {
		this.serialLaptop = serialLaptop;
	}
	
	
	
}
