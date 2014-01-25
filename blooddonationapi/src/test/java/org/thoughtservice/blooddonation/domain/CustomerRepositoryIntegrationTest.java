package org.thoughtservice.blooddonation.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.thoughtservice.blooddonation.AbstractIntegrationTest;
import org.thoughtservice.blooddonation.domain.Customer.BloodGroup;
import org.thoughtservice.blooddonation.domain.Customer.Status;

public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	CustomerRepository repository;
	
	@Before
	public void createDummyCustomer(){
		Assert.notNull(repository, "Customer repository should not be null");
		
		if (repository.count() > 0) {
			return;
		}
		
		Address address = new Address();
		address.setAddressLine1("ABC");
		address.setAddressLine2("CDE");
		address.setAddressLine3("212SS");
		address.setMobilePhone("9400300925");
		
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address);
		
		Customer customer = new Customer();
		customer.setAddress(addressList);
		customer.setEmailAddress("mailtoshinu@gmail.com");
		customer.setFirstName("Shinu");
		customer.setLastName("Suresh");
		customer.setStatus(Status.AVAILABLE);
		customer.setBloodGroup(BloodGroup.OPOSITIVE);
		
		Customer customer1 = new Customer();
		customer1.setAddress(addressList);
		customer1.setEmailAddress("ammu@gmail.com");
		customer1.setFirstName("Ammu");
		customer1.setLastName("Shinu");
		customer1.setStatus(Status.NOT_AVAILABLE);
		customer1.setBloodGroup(BloodGroup.OPOSITIVE);
		
		repository.save(Arrays.asList(customer,customer1));
	}
	
	@Test
	public void findByAvailability(){
		assertEquals("Ammu",((Customer)repository.findByStatus(Status.NOT_AVAILABLE).get(0)).getFirstName());
	}
	
	@Test
	public void findByGroup(){
		assertEquals(BloodGroup.OPOSITIVE,((Customer)repository.findByBloodGroup(BloodGroup.OPOSITIVE).get(0)).getBloodGroup());
	}
	
	@Test
	public void findByEmailAddress(){
		assertEquals("ammu@gmail.com",((Customer)repository.findByEmailAddress("ammu@gmail.com").get(0)).getEmailAddress());
	}
}
