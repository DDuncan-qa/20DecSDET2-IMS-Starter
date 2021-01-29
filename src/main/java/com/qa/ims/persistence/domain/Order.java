package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private Long orderId;
	private Customer orderCustomer;
	private double orderValue;
	List <Item> orderItems = new ArrayList<>();
	
	public Order (Long orderId, Customer orderCustomer, double orderValue, List<Item> orderItems) {
		super();
		this.orderId = orderId;
		this.orderCustomer = orderCustomer;
		this.orderValue = orderValue;
		this.orderItems = orderItems;
	}
	
	public Order (Long orderId, Customer orderCustomer, double orderValue) {
		super();
		this.orderId = orderId;
		this.orderCustomer = orderCustomer;
		this.orderValue = orderValue;
	}
	public Order (Customer orderCustomer, double orderValue) {
		super();
		this.orderCustomer = orderCustomer;
		this.orderValue = orderValue;
		
		
	
	
}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Customer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(Customer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public List<Item> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Item> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		StringBuilder order = new StringBuilder();
		order.append(
				String.format("%s: %s %s", this.orderId, orderCustomer.getFirstName(), orderCustomer.getSurname()));
		if (this.orderItems.isEmpty()) {
			order.append("\n -> No items found in this order.");
		} else {
			order.append(String.format(" - value = £%.2f", this.orderValue));
			this.orderItems.forEach(item -> {
				order.append("\n -> ");
				order.append(String.format("%s: £%.2f", item.getname(), item.getvalue()));
				
			});
			
		}
		return order.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderCustomer == null) ? 0 : orderCustomer.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		long temp;
		temp = Double.doubleToLongBits(orderValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderCustomer == null) {
			if (other.orderCustomer != null)
				return false;
		} else if (!orderCustomer.equals(other.orderCustomer))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (Double.doubleToLongBits(orderValue) != Double.doubleToLongBits(other.orderValue))
			return false;
		return true;
	}

	
	
}
