package com.capgemini.flp.dao;

import java.util.Iterator;
import java.util.List;

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
	public String returnGoods(String customer_email_Id, String merchant_email_Id, int product_Id, int product_Quantity) {

		Customer customer = null;
		String s = null;
		int newQuantity = 0;
		try {
			String jql = "select a from customer_product a where a.customer_email_Id=:email_Id";
			TypedQuery<Customer> typedQuery = entityManager.createQuery(jql, Customer.class);
			typedQuery.setParameter("email_Id", customer_email_Id);
			List<Customer> customerList = typedQuery.getResultList();
			Iterator<Customer> iterator = customerList.iterator();
			while(iterator.hasNext())
			{
				if(iterator.next().getProduct_Id() == product_Id){
					if(iterator.next().getProduct_Quantity() >= product_Quantity){
					newQuantity = iterator.next().getProduct_Id() - product_Quantity;
					iterator.next().setProduct_Quantity(newQuantity);
					entityManager.merge(customer);
					s = receivedGoodsMerchant(merchant_email_Id, product_Id, product_Quantity);
					} 		
				}
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			s = s+" Goods not Returned by customer";
		}
		return s;
	}
    
	public String receivedGoodsMerchant(String merchant_email_Id, int product_Id, int product_Quantity){
	
		Merchant merchant = null;
		String s = null; 
		int newQuantity = 0;
		try {
			String jql = "select a from merchant_product a where a.merchant_email_Id=:email_Id";
			TypedQuery<Merchant> typedQuery = entityManager.createQuery(jql, Merchant.class);
			typedQuery.setParameter("email_Id", merchant_email_Id);
			List<Merchant> merchantList = typedQuery.getResultList();
			Iterator<Merchant> iterator = merchantList.iterator();
			while(iterator.hasNext())
			{
				if(iterator.next().getProduct_Id() == product_Id){
					if(iterator.next().getProduct_Quantity() >= product_Quantity){
					newQuantity = iterator.next().getProduct_Id() + product_Quantity;
					iterator.next().setProduct_Quantity(newQuantity);
					entityManager.merge(merchant);
					s = "Products Successfully Returned";
					} 		
				}
			}
		} catch (PersistenceException e) {
			// TODO: Log to file
			s = s+" Goods not Returned to Merchant";
		}
		return s;
	}
}
