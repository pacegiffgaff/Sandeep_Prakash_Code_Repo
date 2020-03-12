package com.giffgaff.ims.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

	@Id
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
	)
	@GenericGenerator(
			name = "native",
			strategy = "native"
	)
	@Column(name="prod_id")
	private Long productId;

	@Column(name="prod_name")

	private String productName;

	@Column(name="prod_desc")
	private String description;

	@Column(name="prod_type")
	private String productType;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "prod_id")
	private List<ProductComponent> productComponentList = new ArrayList<>();

	public Product() {	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<ProductComponent> getProductComponentList() {
		return productComponentList;
	}

	public void setProductComponentList(List<ProductComponent> productComponentList) {
		this.productComponentList = productComponentList;
	}
}
