package com.cognizant.eauction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.eauction.entities.Seller;
import com.cognizant.eauction.exception.PasswordInvalidException;
import com.cognizant.eauction.exception.UserNotFoundException;
import com.cognizant.eauction.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	public SellerRepository sellerRepository;

	
	
	public Seller setSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	
	
	public Seller login(Seller seller) {
		Seller sellerobj = sellerRepository.findByEmail(seller.getEmail());
		if (sellerobj == null) {
			throw new UserNotFoundException("Seller not found. Try Again!!");
		} 
		else if (sellerobj != null && !(seller.getPassword().equals(sellerobj.getPassword()))) {
			throw new PasswordInvalidException("Password is Invalid. Try Again!!");
		}
		return sellerobj;
	}
	
	
}
