package com.example.apicalling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicalling.service.ProductAPIService;

import jakarta.websocket.server.PathParam;


@RestController
public class ProductAPIController {
	
	@Autowired
	private ProductAPIService service;
	
	@GetMapping("/getProducts")
	public List<String> addProduct(@PathParam(value = "category") List<String> category) {
		
		
		return service.getProduct(category);
	}

}
