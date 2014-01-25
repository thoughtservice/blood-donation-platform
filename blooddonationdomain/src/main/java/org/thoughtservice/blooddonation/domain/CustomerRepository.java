package org.thoughtservice.blooddonation.domain;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.thoughtservice.blooddonation.domain.Customer.BloodGroup;
import org.thoughtservice.blooddonation.domain.Customer.Status;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByStatus(@Param("status") Status status);
	List<Customer> findByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);
	List<Customer> findByEmailAddress(@Param("emailAddress") String emailAddress);
}
