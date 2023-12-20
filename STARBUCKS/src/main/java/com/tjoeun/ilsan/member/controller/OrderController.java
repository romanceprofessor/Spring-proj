package com.tjoeun.ilsan.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tjoeun.ilsan.member.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/order/list", method = RequestMethod.GET)
	public String getOrderList(Model model) {
		
		model.addAttribute("orderList", orderService.getOrderList());
		
		return "order/list";
	}
	
	@RequestMapping(value = "/order/orderView", method = RequestMethod.GET)
	public String getOrderView(Model model) {
		
		return "order/orderView";
	}
	
	@RequestMapping(value = "/order/order", method = RequestMethod.POST)
	public String order(Model model, @RequestParam Map map) {
		try {
			orderService.order(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

}
