package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDAOTest {
	private Order order1;
	private Item Laptop = new Item(1L, "name", 500.00);
	private Item item1 = new Item(2L, "name1", 1.00);
	private Item item2 = new Item(3L, "name2", 2.00);
	private final OrderDao DAO = new OrderDao(new ItemDao(), new CustomerDao());

	@Before
	public void setup() {
		DatabaseUtilities.connect();
		DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1L, "Laptop", 500.00));
		itemList.add(new Item(2L, "item1", 1.00));

		Order order1 = new Order(1L, new Customer(1L, "jordan", "harrison"), 501.00, itemList);

	}

	@Test
	public void testCreate() {
		final Order created = new Order(6L, new Customer(1L, "jordan", "harrison"), 0.0);
		assertEquals(created, DAO.create(created));

	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, new Customer(1L, "jordan", "harrison"), 501.0));
		expected.add(new Order(2L, new Customer(1L, "jordan", "harrison"), 0.0));
		expected.add(new Order(3L, new Customer(1L, "jordan", "harrison"), 0.0));
		expected.add(new Order(4L, new Customer(1L, "jordan", "harrison"), 0.0));
		expected.add(new Order(5L, new Customer(1L, "jordan", "harrison"), 0.0));
		assertEquals(expected, DAO.readAll());

	}

	@Test
	public void testReadLatest() {
		final Order expected = new Order(5L, new Customer(1L, "jordan", "harrison"), 0.0);
		assertEquals(expected, DAO.readLatest());

	}

	@Test
	public void testUpdate() {
		assertEquals(null, DAO.update(null));

	}

	@Test
	public void testDelete() {
		assertEquals(1L, DAO.delete(1L));

	}

	@Test
	public void testreadOrder() {
		final long ID = 2L;
		final Order expected = new Order(2L, new Customer(1L, "jordan", "harrison"), 0.0);
		assertEquals(expected, DAO.readOrder(ID));

	}

	@Test
	public void testUpdateAdd() {
		final Order expected = new Order(4L, new Customer(1L, "jordan", "harrison"), 0.0);
        assertEquals(expected, DAO.update(order1));

	}
	
}
