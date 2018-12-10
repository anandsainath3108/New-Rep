package com.capgemini.flp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flp.dao.IReturnGoodsDao;

@Service
@Transactional
public class ReturnGoodsServiceImpl implements IReturnGoodsService {

	@Autowired
	IReturnGoodsDao returnGoodsDao;
	
	@Override
	public String returnGoods(String customer_email_Id,
			String merchant_email_Id, int product_Id, int product_Quantity) {
		// TODO Auto-generated method stub
		return returnGoodsDao.returnGoods(customer_email_Id, merchant_email_Id, product_Id, product_Quantity);
	}

}
