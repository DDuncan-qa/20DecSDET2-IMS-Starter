package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DatabaseUtilities;

public class ItemDao implements IDomainDao<Item> { 
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	 @Override
	    public Item create(Item item) {
	        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
	                PreparedStatement statement = connection
	                        .prepareStatement("INSERT INTO items(item_name, item_value) VALUES (?, ?)");) {
	            statement.setString(1, item.getItemName());
	            statement.setDouble(2, item.getItemValue());
	            statement.executeUpdate();
	            return readLatest();
	        } catch (Exception e) {
	            LOGGER.debug(e);
	            LOGGER.error(e.getMessage());
	        }
			return null;

}

	public Item readLatest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
