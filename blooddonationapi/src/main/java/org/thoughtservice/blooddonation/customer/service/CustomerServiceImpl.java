package org.thoughtservice.blooddonation.customer.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.thoughtservice.blooddonation.domain.Customer;
import org.thoughtservice.blooddonation.domain.CustomerRepository;


/**
 * Implementation class of {@link CustomerService} which will delegate persistence operations to repository
 * class {@link CustomerRepository}  
 * @author ammu
 *
 */
@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerServiceImpl implements CustomerService{

	private final @NonNull CustomerRepository customerRepository; 
	
	@Override
	public Customer create(Customer customer) {
		if(!StringUtils.isEmpty(customer.getEmailAddress())){
			//validates if customer is already registered
			if(customerRepository.findByEmailAddress(customer.getEmailAddress()) == null){
				return customerRepository.save(customer);
			}else{
				throw new CustomerException(customer, "Customer is already registered.");
			}			
		} else {
			throw new CustomerException(customer, "Please provide an email address for registering.");
		}		
	}

	@Override
	public Customer delete(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateInfo(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deactivate(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer activate(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
