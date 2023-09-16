package com.cognizant.eauction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.eauction.entities.Buyer;
import com.cognizant.eauction.exception.PasswordInvalidException;
import com.cognizant.eauction.exception.UserNotFoundException;
import com.cognizant.eauction.repository.BuyerRepository;

@Service
public class BuyerService {

	@Autowired
	private BuyerRepository buyerRepository;

	
	public Buyer setBuyer(Buyer buyer) {
		return buyerRepository.save(buyer);
	}
	

	public Buyer login(Buyer buyer) {
		Buyer buyerobj = buyerRepository.findByEmail(buyer.getEmail());
		if (buyerobj == null) {
			throw new UserNotFoundException("Buyer not found");
		} 
		else if (buyerobj != null && !(buyer.getPassword().equals(buyerobj.getPassword()))) {
			throw new PasswordInvalidException("Password is Invalid");
		}
		return buyerobj;
	}

}
