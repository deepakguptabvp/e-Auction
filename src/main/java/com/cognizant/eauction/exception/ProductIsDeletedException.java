package com.cognizant.eauction.exception;

public class ProductIsDeletedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductIsDeletedException(String message) {
		super(message);
	}
	
}
