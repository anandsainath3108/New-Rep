package com.capgemini.flp.dao;

public interface IReturnGoodsDao {

	public String returnGoodsCustomer(String exchangeStatus, String productDescription, String customer_email_Id, String merchant_email_Id, int product_Id, int product_Quantity);
    public String returnGoodsMerchant(String exchangeStatus, int product_Id, int product_Quantity);
}
