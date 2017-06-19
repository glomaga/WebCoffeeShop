package edu.mum.coffee.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int id;
	@Size(min=4, max=50, message="{Size.Product.name.validation}")
	private String productName;
	
	@Size(min=4, max=50, message="{Size.Product.description.validation}")
	private String description;
	
	@Min(value=1, message="{Min.Product.unitPrice.validation}")
	private double price;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message= "{NotNull.Product.productType.validation}")
	private ProductType productType;

	public Product() {
		super(); // default constructor
	}

	public Product(String productName, String description, double price, ProductType productType) {
		super();
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.productType = productType;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", productType=" + productType + "]";
	}

}
