package org.thoughtservice.blooddonation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.Cascade;
import org.thoughtservice.blooddonation.domain.core.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Getter
@Setter
@ToString(exclude = "password")
@Table(name = "customer")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Customer extends AbstractEntity {

	@Column(name = "USER_NAME")
	private String username;	
	private String password;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	private String firstName;
	private String lastName;
	@Column(name = "PASSWORD_CHANGE_REQUIRED")
	private Boolean passwordChangeRequired = false;
	private Status status;
	private BloodGroup bloodGroup;
	
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	private List<Address> address = new ArrayList<Address>();

	public static enum BloodGroup{
		ONEGATIVE,
		OPOSITIVE,
		ANEGATIVE,
		APOSITIVE,
		BNEGATIVE,
		BPOSITIVE,
		ABNEGATIVE,
		ABPOSITIVE
		
	}
	
	public static enum Status {

		/**
		 * Customer is available for donation
		 */
		AVAILABLE,
		NOT_AVAILABLE
	}
}
