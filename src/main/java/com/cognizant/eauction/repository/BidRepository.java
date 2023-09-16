package com.cognizant.eauction.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.eauction.entities.Bid;
import com.cognizant.eauction.entities.Buyer;
import com.cognizant.eauction.entities.Product;
import com.sun.xml.bind.v2.model.core.ID;

public interface BidRepository extends JpaRepository<Bid, Integer> {

	List<Bid> findByProductId(int productId);

	ID deleteById(@Valid Bid bidId);

	Bid findByProductAndBuyer(Product product, Buyer buyer);
	
}
