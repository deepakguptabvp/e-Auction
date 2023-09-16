package com.cognizant.eauction.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eauction.entities.ProductCategory;
import com.cognizant.eauction.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public List<ProductCategory> getAllProductCategories() {
		return productCategoryRepository.findAll();
	}

}
