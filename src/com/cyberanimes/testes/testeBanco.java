package com.cyberanimes.testes;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public class testeBanco {
	public void con() {
		SQLiteDataSource ds = null;

		try {
			ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\carlos\\eclipse-workspace\\site\\banco.db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = ds.getConnection()) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ds.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
