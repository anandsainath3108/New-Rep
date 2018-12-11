package com.capgemini.flp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_product")
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_Id")
	private int productId;
	
	private String product_Name;
	private String product_Category;
	private String product_Description;
	private double product_Price;
	private String product_Image;
	private int product_Quantity;
	private String product_Discount;
	private int timeForDiscount;
	private String product_Promo;
	private String timeForPromo;
	private int numberOfProductSold;
	private double sellingCost;
	private double exchangeAmount;

	@Column(name = "merchant_email_Id")
	private String merchantEmailId;
	@Column(name = " product_Exchanged")
	private String productExchanged;

	public Merchant() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
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

	public int getProduct_Quantity() {
		return product_Quantity;
	}

	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	public String getProduct_Discount() {
		return product_Discount;
	}

	public void setProduct_Discount(String product_Discount) {
		this.product_Discount = product_Discount;
	}

	public int getTimeForDiscount() {
		return timeForDiscount;
	}

	public void setTimeForDiscount(int timeForDiscount) {
		this.timeForDiscount = timeForDiscount;
	}

	public String getProduct_Promo() {
		return product_Promo;
	}

	public void setProduct_Promo(String product_Promo) {
		this.product_Promo = product_Promo;
	}

	public String getTimeForPromo() {
		return timeForPromo;
	}

	public void setTimeForPromo(String timeForPromo) {
		this.timeForPromo = timeForPromo;
	}

	public int getNumberOfProductSold() {
		return numberOfProductSold;
	}

	public void setNumberOfProductSold(int numberOfProductSold) {
		this.numberOfProductSold = numberOfProductSold;
	}

	public double getSellingCost() {
		return sellingCost;
	}

	public void setSellingCost(double sellingCost) {
		this.sellingCost = sellingCost;
	}

	public double getExchangeAmount() {
		return exchangeAmount;
	}

	public void setExchangeAmount(double exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}

	public String getMerchantEmailId() {
		return merchantEmailId;
	}

	public void setMerchantEmailId(String merchantEmailId) {
		this.merchantEmailId = merchantEmailId;
	}


	public String getProductExchanged() {
		return productExchanged;
	}

	public void setProductExchanged(String productExchanged) {
		this.productExchanged = productExchanged;
	}

	@Override
	public String toString() {
		return "Merchant [product_Id=" + productId + ", product_Name="
				+ product_Name + ", product_Category=" + product_Category
				+ ", product_Description=" + product_Description
				+ ", product_Price=" + product_Price + ", product_Image="
				+ product_Image + ", product_Quantity=" + product_Quantity
				+ ", product_Discount=" + product_Discount
				+ ", timeForDiscount=" + timeForDiscount + ", product_Promo="
				+ product_Promo + ", timeForPromo=" + timeForPromo
				+ ", numberOfProductSold=" + numberOfProductSold
				+ ", sellingCost=" + sellingCost + ", exchangeAmount="
				+ exchangeAmount + ", merchantEmailId=" + merchantEmailId
				+ ", product_Exchanged=" + productExchanged + "]";
	}
	
	
}