package com.training.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.model.Payment;

@RestController
public class PaymentController {

private String providerUrl = "http://localhost:9004/order/getorderedbook/isbn/{isbn}/qty/{qty}";
	
	//private String providerUrl="";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getpayment/isbn/{isbn}/qty/{qty}")
	public Payment getOrderedBook(@PathVariable("isbn") String isbn,@PathVariable("qty") int quantity)
	{
		
		Map<String,String> map = new HashMap<>();
		
		map.put("isbn", isbn);
		map.put("qty", quantity+"");
		
		Payment payment = restTemplate.getForObject(providerUrl, Payment.class, map);
		payment.setPaymentType("Credit Card");
		
		
		return payment; 
	}
}
