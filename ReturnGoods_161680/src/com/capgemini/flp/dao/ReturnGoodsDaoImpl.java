package com.capgemini.flp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.flp.entity.Customer;
import com.capgemini.flp.entity.Merchant;

@Repository
@Transactional
public class ReturnGoodsDaoImpl implements IReturnGoodsDao {
	
	@PersistenceContext
	EntityManager entityManager = null;

	@Override
	public String returnGoodsCustomer(String exchangeStatus, String productDescription, String customer_email_Id, String merchant_email_Id, int product_Id, int product_Quantity) {

		String s = null;
		int newQuantity = 0;
		try {
			String jql = "select a from Customer a where a.customerEmailId=:email_Id and a.productId=:product_Id";
			TypedQuery<Customer> typedQuery = entityManager.createQuery(jql, Customer.class);
			typedQuery.setParameter("email_Id", customer_email_Id);
			typedQuery.setParameter("product_Id", product_Id);
			Customer c = typedQuery.getSingleResult();
			{
				if(c.getProductId() == product_Id){
					if(c.getProductQuantity() >= product_Quantity ){
						if(exchangeStatus.equals("Exchange Products")){
					c.setExchangeStatus(exchangeStatus);
					c.setProductDescription(productDescription);
					entityManager.merge(c);
					s = "Awaiting to return the Products to Merchant, You will receive the Products within 5 Working Days";
						}
						else if(exchangeStatus.equals("Return goods and Refund Money")||exchangeStatus.equals("Cancel Order")){
							newQuantity = c.getProductQuantity() - product_Quantity;
							double amountRefunded = (c.getProduct_Price()*product_Quantity*95)/100;
							c.setAmountRefunded(amountRefunded);
							c.setExchangeStatus(exchangeStatus);
							c.setProductDescription(productDescription);
							c.setProductQuantity(newQuantity);
							entityManager.merge(c);
							s = "Goods are awaiting to be returned to merchant, You will receive the Amount within 5 Working Days";
						}
					}
				}
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			s = s +" Goods not Returned by customer";
		}
		return s;
	}

	@Override
	public String returnGoodsMerchant(String exchangeStatus, int product_Id, int product_Quantity) {
		String s = null;
		int newQuantity = 0, newAvailableQuantity = 0;
		try {
			String jql = "select b from Merchant b where b.productId=:product_Id";
			TypedQuery<Merchant> typedQuery = entityManager.createQuery(jql, Merchant.class);
			typedQuery.setParameter("product_Id", product_Id);
			Merchant m = typedQuery.getSingleResult();
			{
				if(m.getProductId() == product_Id){
					if(exchangeStatus.equals("Exchange Products")){
					m.setProductExchanged(exchangeStatus);
					entityManager.merge(m);
					s = "Products to be returned are Dispatched";
				    }
				else if(exchangeStatus.equals("Return goods and Refund Money")||exchangeStatus.equals("Cancel Order")){
						newQuantity = m.getNumberOfProductSold() - product_Quantity;
						newAvailableQuantity = m.getProduct_Quantity() + product_Quantity;
						m.setNumberOfProductSold(newQuantity);
						m.setProduct_Quantity(newAvailableQuantity);
						entityManager.merge(m);
						s = "Amount Successfully Transferred";
					}
				}
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			s = s+" Goods not Returned by customer";
		}
		return s;
	}	
}
