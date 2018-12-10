package com.capgemini.flp.dao;

public interface IReturnGoodsDao {

	public String returnGoods(String customer_email_Id, String merchant_email_Id, int product_Id, int product_Quantity);
}
