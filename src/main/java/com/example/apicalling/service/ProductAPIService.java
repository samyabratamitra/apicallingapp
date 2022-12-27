package com.example.apicalling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.apicalling.controller.response.Product;

@Service
public class ProductAPIService {
//
//	@Autowired
//	private URIConfig config;
	
	public List<String> getProduct(List<String> category) {
		RestTemplate restTemplate = new RestTemplate();
		List<Product> productList = new ArrayList<>();
		List<String> pdtNameList = new ArrayList<>();
		String URI = "http://localhost:9191/getProducts";
		
		productList = restTemplate.getForObject(URI, List.class);

		if (CollectionUtils.isEmpty(category)) {
			
			productList.stream().forEach(pdt -> {
				pdtNameList.add(pdt.getPdtName());
				
			});
		} else {
			productList.stream().forEach(pdt -> {
				
				if (category.contains(pdt.getCategory()))
					pdtNameList.add(pdt.getPdtName());
				
			});
		}

		return pdtNameList;
	}

}
