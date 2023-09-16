package com.cognizant.eauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.eauction.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
