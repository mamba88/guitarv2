package com.guitar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.guitar.model.GuitarSpec;
import com.guitar.model.Inventory;

public class InventoryDao {
	public InventoryDao(){
		
	}
	
	public Inventory getAllGuitars() throws Exception{
		
		JDBCsqlite jdbc =  new JDBCsqlite();
		Connection connection = jdbc.connection;
		PreparedStatement ps = connection.prepareStatement("select * from Guitar");
		Inventory inventory = new Inventory();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){			
			inventory.addGuitar(rs.getString(1),rs.getDouble(4),rs.getString(6), new GuitarSpec(rs.getString(5),rs.getString(7),rs.getString(2),rs.getString(3)));
		}
		if(rs != null){
			rs.close();
		}
		ps.close();
		connection.close();

		return (Inventory) Inventory.getGuitars();
	}

}
