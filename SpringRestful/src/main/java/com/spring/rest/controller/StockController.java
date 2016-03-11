package com.spring.rest.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Stock;

@RestController
@RequestMapping("/xoriant")
public class StockController {

	@RequestMapping(value="/stock", method=RequestMethod.POST,
	consumes=MediaType.APPLICATION_JSON_VALUE,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public Stock createStock(@RequestBody Stock stock) {
		System.out.println("Request stock: " + stock);
		return stock;
	}
	
	@RequestMapping(value="/stock/{id}", method=RequestMethod.GET,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public double getStockById(@PathVariable(value="id")  String stockId) {
		System.out.println("StockId: " + stockId + " - price = 5");
		return 5.0;
	}
}
