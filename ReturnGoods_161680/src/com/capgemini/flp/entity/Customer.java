package com.capgemini.flp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_product")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_Id")
	private int productId;
	private String product_Name;
	private String product_Category;
	
	@Column(name="product_Description")
	private String productDescription;
	private double product_Price;
	private String product_Image;
	
	@Column(name="product_Quantity")
	private int productQuantity;
	
	@Column(name="customer_email_Id")
	private String customerEmailId;
	
    private String exchangeStatus;
    private double amountRefunded;

	public Customer() {

	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Category() {
		return product_Category;
	}

	public void setProduct_Category(String product_Category) {
		this.product_Category = product_Category;
	}
    	
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(double product_Price) {
		this.product_Price = product_Price;
	}

	public String getProduct_Image() {
		return product_Image;
	}

	public void setProduct_Image(String product_Image) {
		this.product_Image = product_Image;
	}

	public String getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}

	public double getAmountRefunded() {
		return amountRefunded;
	}

	public void setAmountRefunded(double amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	@Override
	public String toString() {
		return "Customer [productId=" + productId + ", product_Name="
				+ product_Name + ", product_Category=" + product_Category
				+ ", productDescription=" + productDescription
				+ ", product_Price=" + product_Price + ", product_Image="
				+ product_Image + ", productQuantity=" + productQuantity
				+ ", customerEmailId=" + customerEmailId + ", exchangeStatus="
				+ exchangeStatus + ", amountRefunded=" + amountRefunded + "]";
	}
}