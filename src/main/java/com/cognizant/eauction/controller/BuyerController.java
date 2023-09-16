package com.cognizant.eauction.controller;

import java.util.List; 
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.eauction.entities.Bid;
import com.cognizant.eauction.entities.Buyer;
import com.cognizant.eauction.entities.Product;
import com.cognizant.eauction.entities.ProductCategory;
import com.cognizant.eauction.entities.Seller;
import com.cognizant.eauction.service.BidService;
import com.cognizant.eauction.service.BuyerService;
import com.cognizant.eauction.service.ProductCategoryService;
import com.cognizant.eauction.service.ProductService;
import com.cognizant.eauction.service.SellerService;

@CrossOrigin("http://localhost:4200")
@RestController
public class BuyerController {

	@Autowired
	private BidService bidService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductCategoryService productCategoryService;	
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private SellerService sellerService;

	
//	------------------------------------S E L L E R------------------------------------
	
	@PostMapping("/e-auction/api/v1/seller/add-product")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product) {
		return new ResponseEntity<>(productService.setProduct(product), HttpStatus.CREATED);
	} 

	@DeleteMapping("/e-auction/api/v1/seller/delete/{productId}")
	public void deleteProductById(@PathVariable int productId) {
		productService.deleteProduct(productId);
	} 
	   
	@GetMapping("/e-auction/api/v1/seller/show-bids/{productId}")
	public ResponseEntity<Optional<Product>> getProduct(@PathVariable int productId) {
		return new ResponseEntity<>(productService.fetchProductById(productId), HttpStatus.OK);
	}
	
	@PostMapping("/e-auction/api/v1/seller/login")
	public ResponseEntity<Seller>loginSeller(@RequestBody @Valid Seller seller) {
//		System.out.println(seller);
		
		return new ResponseEntity<Seller>(sellerService.login(seller), HttpStatus.OK);
	}  
	
	
	
//	-------------------------------------B U Y E R-----------------------------------
	
	@DeleteMapping("/e-auction/api/v1/buyer/delete-bid/{bidId}")
	public void deleteBidForSpecificProduct(@PathVariable int bidId) {
		bidService.deleteBidById(bidId);
	}
 
	@PutMapping("/e-auction/api/v1/buyer/update-bid")
	public ResponseEntity<Bid> updateBid(@RequestBody @Valid Bid bid) {
		return new ResponseEntity<Bid>(bidService.updateBid(bid), HttpStatus.OK);
	} 
	
	@PostMapping("/e-auction/api/v1/buyer/place-bid")
	public ResponseEntity<Bid> addBid(@RequestBody @Valid Bid bid,@RequestHeader("buyerEmail") String buyerEmail) {
		return new ResponseEntity<>(bidService.setBid(bid,buyerEmail), HttpStatus.OK);
	}
	
	@GetMapping("/e-auction/api/v1/buyer/get-bid-for-specific-product-specific-buyer/{productId}")
	public ResponseEntity<Bid> getBidForSpecificProductSpecificBuyer(@PathVariable int productId,@RequestHeader("buyerEmail") String buyerEmail) {
		return new ResponseEntity<Bid>(bidService.getBidForSpecificProductSpecificBuyer(productId,buyerEmail), HttpStatus.OK);
	}
	
	@PostMapping("/e-auction/api/v1/buyer/login")
	public ResponseEntity<Buyer>loginBuyer(@RequestBody @Valid Buyer buyer) {
		return new ResponseEntity<Buyer>(buyerService.login(buyer), HttpStatus.OK);
	}  
	       
 
	@PostMapping("/e-auction/api/v1/buyer/register")
	public ResponseEntity<Buyer>addBuyer(@RequestBody @Valid Buyer buyer) {
		return new ResponseEntity<>(buyerService.setBuyer(buyer), HttpStatus.CREATED);
	}
	 
		          
	
//	-------------------------------------P R O D U C T------------------------------------

	@GetMapping("/e-auction/api/v1/all-product")
	public ResponseEntity<List<Product>> allProduct() {
//	System.out.println(productService.getAllProducts());
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/e-auction/api/v1/bids-for-specific-product/{productId}")
	public ResponseEntity<List<Bid>> getBidsForSpecificProduct(@PathVariable int productId) {
		return new ResponseEntity<List<Bid>>(bidService.getBidForSpecificProduct(productId),HttpStatus.OK);
	} 
	
	@GetMapping("/e-auction/api/v1/product-category-type")
	public ResponseEntity<List<ProductCategory>>getProductCategory() {
		return new ResponseEntity<List<ProductCategory>>(productCategoryService.getAllProductCategories(),HttpStatus.OK);
	}

	
} 
 