package com.cognizant.eauction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eauction.entities.Bid;
import com.cognizant.eauction.entities.Product;
import com.cognizant.eauction.exception.ProductNotDeleteException;
import com.cognizant.eauction.repository.BidRepository;
import com.cognizant.eauction.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BidRepository bidRepository;

	//save product	
	public Product setProduct(Product product) {
		return productRepository.save(product);
	}
	
	//fetch by Id
	public Optional<Product> fetchProductById(int productId) {
		return productRepository.findById(productId);
	}
	 
	//get all products
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// delete product		
	public void deleteProduct(int productId) {
		List<Bid> bidForSpecificProduct = bidRepository.findByProductId(productId);
		if (bidForSpecificProduct.size() > 0) {
			throw new ProductNotDeleteException("Bid is ongoing. Cannot delete the product");
		}
		productRepository.deleteById(productId);
	}
	 
}
