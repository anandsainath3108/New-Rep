package com.capgemini.flp.service;

public interface IReturnGoodsService {

	public String returnGoodsCustomer(String exchangeStatus, String productDescription, String customer_email_Id, String merchant_email_Id, int product_Id, int product_Quantity);
	public String returnGoodsMerchant(String exchangeStatus, int product_Id, int product_Quantity);
}
