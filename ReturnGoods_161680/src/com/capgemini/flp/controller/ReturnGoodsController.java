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

		List<String> myList=new ArrayList<>();
		myList.add("--Select--");
		myList.add("Damaged Goods");
		myList.add("Product not matching to product Ordered");
		myList.add("Delay in Delivery");
		map.put("returnGoodsReason", myList);		
		}
	
	@RequestMapping(value="successpage",method=RequestMethod.POST)
	public ModelAndView goodsReturned(@ModelAttribute("goods")  Customer c, Merchant m){ 
		String customer_email_Id = c.getCustomer_email_Id();
		String merchant_email_Id = m.getMerchant_email_Id();
		int product_Id = c.getProduct_Id();
		int product_Quantity = c.getProduct_Quantity();
		String message = returnGoodsService.returnGoods(customer_email_Id, merchant_email_Id, product_Id, product_Quantity);
		return new ModelAndView("successpage", "details", message);
	}
}
