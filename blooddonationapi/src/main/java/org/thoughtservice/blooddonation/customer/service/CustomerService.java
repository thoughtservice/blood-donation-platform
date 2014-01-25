package org.thoughtservice.blooddonation.customer.service;

import org.thoughtservice.blooddonation.domain.Customer;

/**
 * Service interface for Customer
 * 
 * @author ammu
 *
 */
public interface CustomerService {

	Customer create(Customer customer);
	
	Customer delete(Customer customer);
	
	Customer updateInfo(Customer customer);
	
	Customer deactivate(Customer customer);
	
	Customer activate(Customer customer);
}
