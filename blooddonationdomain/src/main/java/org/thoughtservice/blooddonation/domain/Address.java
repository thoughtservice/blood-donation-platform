package org.thoughtservice.blooddonation.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.thoughtservice.blooddonation.domain.core.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Getter
@Setter
@Table(name = "address")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Address extends AbstractEntity{

	private String firstName;
	String lastName;
	String emailAddress;
	String companyName;
	String addressLine1;
	String addressLine2;
	String addressLine3;
	String county;
	String country;
	String postalCode;
	String phone;
	String mobilePhone;
	boolean isdefault;
	
}
