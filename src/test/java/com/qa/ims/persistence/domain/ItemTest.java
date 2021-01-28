package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

public class ItemTest {
	
	
	@Before
	
	
	
	@Test
	public void testConstructor1() {
		Item item = new Item("Cheese", 3.00);
		assertEquals("Cheese", item.
		assertEquals(3.00, item.
	
	}
				@Test
				public void testConstructor2() {
					Item item = new Item(1L,"Cheese", 3.00);
					assertEquals(
					assertEquals("Cheese", item.
					assertEquals(3.00, item.
												
	}

}
