package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DatabaseUtilities;

public class OrderDao implements IDomainDao<Order> {

    public static final Logger LOGGER = LogManager.getLogger();
    private ItemDao itemDao;
    private CustomerDao custDao;
    
    public OrderDao(ItemDao itemDao, CustomerDao custDao) {
    	super();
    	this.itemDao = itemDao;
    	this.custDao = custDao;
    }
    
    
    @Override
    public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Customer cust = custDao.readCustomer(resultSet.getLong("fk_customers_id"));
        double value = resultSet.getDouble("order_value");
        List<Item> items = getItems(id);
        return new Order(id, cust, value, items); 
    }
    
    private List<Item> getItems(Long id) {
    	List<Long> itemIDs = new ArrayList<>();
    	List <Item> finalItem =   new ArrayList<>();
    	try (Connection connection = DatabaseUtilities.getInstance().getConnection();
    			PreparedStatement statement = connection
    					.prepareStatement("select * from orders_items where fk_orders_id = ?");) {
    		statement.setLong(1, id);
    		try (ResultSet resultSet = statement.executeQuery();) {
    			while (resultSet.next()) {
    				itemIDs.add(resultSet.getLong("fk_items_id")); 
    			}
    		}
    	} catch (SQLException e) {
    		LOGGER.debug(e);
    		LOGGER.error(e.getMessage());
    	}
    	   for (Long i : itemIDs) {
    		   
    		
    		finalItem.add(itemDao.read(i));
    	   }
    	   
    	   
    	 return finalItem;
    	
    }
    
       @Override
    public List<Order> readAll() {
    	   List<Order> orders = new ArrayList<>();
    	   
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
            while (resultSet.next()) {
                orders.add(modelFromResultSet(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return orders; 
       }
       
       
       public Order readLatest() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }
       
          
       
    @Override
    public Order create(Order order) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(fk_customers_id) VALUES (?)");) {
            statement.setLong(1, order.getOrderCustomer().getId());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;


    }   
    
	
    public Order readOrder(Long id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE id = ?");) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

 
    @Override
    public Order update(Order order) {
    	try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("UPDATE orders SET order_value = ? WHERE id = ?");) {
            statement.setDouble(1, order.getOrderValue());
            statement.setLong(2, order.getOrderId());
            statement.executeUpdate();
            return readOrder(order.getOrderId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    
   }
    
    @Override
    public int delete(long id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
        		PreparedStatement statement = connection.prepareStatement("Delete from orders where id = ?");) {
        	statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }
    

	  
	 // public double calaculateValue (Long id) {
	    	

	  
//  }
    
    
    
    	
    	
 //  }
    
    public Order addItem(Long orderId, Long id) {
    	try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("INSERT INTO orders_items (fk_orders_id, fk_items_id) VALUES (?, ?)")) {
            statement.setLong(1, orderId);
            statement.setLong(2, id);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
      //  calaculateValue(orderId);
        return readOrder(orderId);
        
        
    }
    
    public Order removeItem(Long orderID, Long itemID) {
    	try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("DELETE FROM orders_items WHERE fk_orders_id = ? and  fk_items_id = ?")) {
            statement.setLong(1, orderID);
            statement.setLong(2, itemID);
            statement.executeUpdate();
    	 } catch (Exception e) {
             LOGGER.debug(e);
             LOGGER.error(e.getMessage());
         }
      //   calaculateValue(orderID);
         return readOrder(orderID);	
	

	
	}

	
	}
	
