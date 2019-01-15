package com.fukutaku.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("customerItems")
@RequestMapping("/customer/items/")
public class ItemsController 
{

	@RequestMapping("001001")
	@ResponseBody
	public String list001001(Model model)
	{
		
		
		return "customer/items/001001";
		
	}
	
	@RequestMapping("001002")
	@ResponseBody
	public String list001002(Model model)
	{
		
		
		return "customer/items/001002";
		
	}
	@RequestMapping("001003")
	@ResponseBody
	public String list001003(Model model)
	{
		
		
		return "customer/items/001003";
		
	}
	@RequestMapping("001004")
	@ResponseBody
	public String list001004(Model model)
	{
		
		
		return "customer/items/001004";
		
	}
	
	
}
