package org.thoughtservice.blooddonation.customer.service;

import lombok.Getter;

import org.springframework.util.Assert;
import org.thoughtservice.blooddonation.domain.Customer;

@Getter
public class CustomerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322523796659374832L;
	private final Customer customer;

	public CustomerException(Customer customer, String message) {
		super(message);
		Assert.notNull(customer);
		this.customer = customer;
		
	}
}
