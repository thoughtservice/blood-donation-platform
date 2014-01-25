package org.thoughtservice.blooddonation.customer.service;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.thoughtservice.blooddonation.domain.Customer;
import org.thoughtservice.blooddonation.domain.CustomerRepository;


/**
 * Unit tests for {@link CustomerServiceImpl}.
 * 
 * @author Shinu
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplUnitTest {
	

	CustomerService customerService;

	@Mock CustomerRepository customerRepository;
	@Mock Customer customer;

	@Rule public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() {
		this.customerService = new CustomerServiceImpl(customerRepository);
	}

	@Test(expected = NullPointerException.class)
	public void rejectsNullCustomerRepository() {
		new CustomerServiceImpl(null);
	}	
	
	@Test
	public void failCustomerWithoutEmail(){
		Customer cust = new Customer();
		cust.setFirstName("Shinu");
		cust.setLastName("Suresh");		
		
		exception.expect(CustomerException.class);
		exception.expectMessage(containsString("email"));
		customerService.create(cust);		
	}
	
	@Test
	public void failIfEmailAlreadyRegistered(){
		
		when(customer.getEmailAddress()).thenReturn("a@a.com");
		when(customerRepository.findByEmailAddress("")).thenReturn(new ArrayList<Customer>());
		
		exception.expect(CustomerException.class);
		exception.expectMessage(containsString("already"));
		customerService.create(customer);		
	}

}
