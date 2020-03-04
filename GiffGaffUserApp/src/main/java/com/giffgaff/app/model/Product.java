package com.giffgaff.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	private String prodName;
	private String prodDesc;
	private double price;

	public Product() {

	}

	public Product(String prodName, String prodDesc, double price) {

		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.price = price;
	}

	public Product(Long pid, String prodName, String prodDesc, double price) {
		this.pid = pid;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.price = price;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
