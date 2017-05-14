package com.guitar.dao;

import java.sql.*;
import java.io.*;

public class JDBCsqlite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Connection connection = null;
	
	public JDBCsqlite(){
		try {
			Class.forName("org.sqlite.JDBC");
			connection= DriverManager.getConnection("jdbc:sqlite:C:/sqlite/guitarV2.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
