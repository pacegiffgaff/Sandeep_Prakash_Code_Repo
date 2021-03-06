package com.giffgaff.ims.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "prod_id")
	private Long id;

	@Column(name = "prod_name")
	private String productName;

	@Column(name = "prod_desc")
	private String description;

	@Column(name = "prod_type")
	private String productType;

	@OneToMany
	@JoinColumn(name = "prod_id")
	private List<RawMaterial> rawMaterialList = new ArrayList<>();

	

	@Column(name = "prod_specification")
	private String specifications;

	public Product() {
	}

	public Long getProductId() {
		return id;
	}

	public void setProductId(Long productId) {
		this.id = productId;
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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public List<RawMaterial> getRawMaterialList() {
		return rawMaterialList;
	}

	public void setRawMaterialList(List<RawMaterial> rawMaterialList) {
		this.rawMaterialList = rawMaterialList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(productName, product.productName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName);
	}
}
