package com.example.apicalling.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.apicalling.controller.response.Product;
import com.fasterxml.jackson.core.type.TypeReference;

import io.micrometer.common.util.StringUtils;

@Service
public class ProductAPIService {
//
//	@Autowired
//	private URIConfig config;
	
	public List<String> getProduct(String category) {
		RestTemplate restTemplate = new RestTemplate();
		List<Product> productList = new ArrayList<>();
		List<String> pdtNameList = new ArrayList<>();
		String URI = "http://localhost:9191/getProducts";
		
		Product[] response = restTemplate.getForObject(URI, Product[].class);
		
		productList = Arrays.asList(response);

		if (StringUtils.isEmpty(category)) {
			
			productList.stream().forEach(pdt -> {
				pdtNameList.add(pdt.getPdtName());
				
			});
		} else {
			productList.stream().forEach(pdt -> {
				
				if (category.equalsIgnoreCase(pdt.getCategory()))
					pdtNameList.add(pdt.getPdtName());
				
			});
		}

		return pdtNameList;
	}

}
