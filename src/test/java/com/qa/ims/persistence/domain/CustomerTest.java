package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Customer.class).verify();
//	}
	@Test
	public void testConstructor() {
		Customer customer = new Customer(1L, "j", "h");
		assertEquals(Customer.class, customer.getClass());
	}
	
	
	
}
