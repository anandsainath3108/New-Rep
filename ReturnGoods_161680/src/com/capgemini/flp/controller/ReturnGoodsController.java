package com.capgemini.flp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.flp.entity.Customer;
import com.capgemini.flp.entity.Merchant;
import com.capgemini.flp.service.IReturnGoodsService;


@Controller
public class ReturnGoodsController {

	@Autowired
	IReturnGoodsService returnGoodsService;
	
	@RequestMapping(value="homepage",method=RequestMethod.GET)
	public String home(){
		return "homepage";
	}
	
	@RequestMapping(value="returngoodspage")
	public void returningOfGoods(@ModelAttribute("goods") Customer c, Map<String,List<String>> map){


		List<String> list1 = new ArrayList<>();
		list1.add("--Select--");
		list1.add("Exchange Products");
		list1.add("Return goods and Refund Money");
		list1.add("Cancel Order");
		map.put("ExchangeRefund",list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("--Select--");
		list2.add("Damaged Goods");
		list2.add("Product not matching to product Ordered");
		list2.add("Delay in Delivery");
		map.put("returnGoodsReason", list2);
		
		
		}
	
	@RequestMapping(value="success",method=RequestMethod.POST)
	public ModelAndView goodsReturned(@ModelAttribute("goods")  Customer c, Merchant m){ 
		String exchangeStatus = c.getExchangeStatus();
		String productDescription = c.getProductDescription();
		String customer_email_Id = c.getCustomerEmailId();
		String merchant_email_Id = m.getMerchantEmailId();
		int product_Id = c.getProductId();
		int product_Quantity = c.getProductQuantity();
		String message1 = returnGoodsService.returnGoodsCustomer(exchangeStatus, productDescription, customer_email_Id, merchant_email_Id, product_Id, product_Quantity);
		String message2 = returnGoodsService.returnGoodsMerchant(exchangeStatus, product_Id, product_Quantity); 
		String message = message1 + "\n" + message2;
		System.out.println(message);
		return new ModelAndView("success", "details", message);
	}
}
