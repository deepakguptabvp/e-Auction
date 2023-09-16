package com.cognizant.eauction.service;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.eauction.entities.Bid;
import com.cognizant.eauction.entities.Buyer;
import com.cognizant.eauction.entities.Product;
import com.cognizant.eauction.exception.ProductIsDeletedException;
import com.cognizant.eauction.repository.BidRepository;
import com.cognizant.eauction.repository.BuyerRepository;
import com.cognizant.eauction.repository.ProductRepository;

@Service
public class BidService {

	@Autowired
	private BidRepository bidRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BuyerRepository buyerRepository;

	public Bid updateBid(@Valid Bid bid) {
		return bidRepository.save(bid);
	}

	public List<Bid> getBidForSpecificProduct(int productId) {
		return bidRepository.findByProductId(productId);
	}

	public void deleteBidById(int bidId) {
		bidRepository.deleteById(bidId);
	}

	public Bid setBid(Bid bid, String buyerEmail) {
		int productId = bid.getProduct().getId();
		if (!productRepository.findById(productId).isPresent()) {
			throw new ProductIsDeletedException("This product is deleted");
		}
		Buyer buyer = buyerRepository.findByEmail(buyerEmail);
		bid.setBuyer(buyer);
		return bidRepository.save(bid);
	}

	public Bid getBidForSpecificProductSpecificBuyer(int productId, String buyerEmail) {
		Product product = productRepository.findById(productId).get();
		Buyer buyer = buyerRepository.findByEmail(buyerEmail);
		return bidRepository.findByProductAndBuyer(product, buyer);
	}
  
}     
     