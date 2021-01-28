package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDAOTest {
	
	private final OrderDao DAO = new OrderDao(null, null);
	
	@Before
	public void setup() {
		 DatabaseUtilities.connect();
	        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	    }

@Test
public void testCreate() {
	final Order created = new Order(2L,null, 1L);
	assertEquals(created, DAO.create(created));
	}

}
