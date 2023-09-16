package com.cognizant.eauction.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.cognizant.eauction.entities.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	
	Buyer findByEmail(String email);

}
