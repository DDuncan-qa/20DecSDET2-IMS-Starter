package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDao;
import com.qa.ims.persistence.dao.OrderDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.JavaUtilities;

public class OrderController implements ICrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDao orderDao;
	private JavaUtilities javaUtilities;

	public OrderController(OrderDao orderDao, JavaUtilities javaUtilities) {
		super();
		this.orderDao = orderDao;
		this.javaUtilities = javaUtilities;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDao.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer id");
		Long customerId = javaUtilities.getLong();
		Order order = orderDao.create(new Order(new Customer(customerId, null, null), 0.0));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public Order update() {
		Order updatedOrder = null;
		LOGGER.info("Please enter an order id");
		Long orderId = javaUtilities.getLong();
		LOGGER.info("Would you like to Add or Remove an item?");
		String action = javaUtilities.getString();
		boolean validInput = true;
		do {
		if (action.equals("Add")) {
			LOGGER.info("Enter the id of the item you would like to add");
			Long id = javaUtilities.getLong();
			updatedOrder = this.orderDao.addItem(orderId, id);

		}

		else if (action.equals("Remove")) {
			LOGGER.info("Enter the id of the item you would like to remove");
			Long id = javaUtilities.getLong();
			updatedOrder = this.orderDao.removeItem(orderId, id);

		} else {
			LOGGER.info("Invalid Selection");
		}
		} while (!validInput);
		LOGGER.info("You have updated your order");
		return updatedOrder;
	}

//        public Double calculateTotal() {
//                LOGGER.info("Please enter your customer id");
//                    Long id = javaUtilities.getLong();
//                    LOGGER.info("Please enter your order id");
//                    Long orderId = javaUtilities.getLong();
//                    Double total = orderDao.calaculateValue(orderId);
//                    LOGGER.info(total);
//                    return total;
//            
//            
//          
//        }
//            
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = javaUtilities.getLong();
		return orderDao.delete(id);
	}

}
