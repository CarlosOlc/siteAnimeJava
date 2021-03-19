package com.cyberanimesV2;

import java.sql.*;

import org.sqlite.SQLiteDataSource;

public class Banco {
	static SQLiteDataSource ds = null;
	static Connection connection = null;
	ResultSet resultSet = null;
	
	// constructor create connection
	public Banco() { 
		try {
			ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\carlos\\eclipse-workspace\\site\\BancoAnimes.db");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = ds.getConnection();
			System.out.println("Conexão Realizada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int adicionaAnime(String name, String link, String img) {
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String command = String.format("INSERT INTO Anime(name_anime, url_anime, img_anime) " 
									 + "VALUES ('%s','%s','%s')", name, link, img);
		try {
			statement.execute(command);
			rs = statement.getGeneratedKeys();
			// return id last anime 
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	public void adicionaEP(int number_ep , String img_ep, String url_ep, int fk_anime, String version) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// inserindo registros
		String command = String.format("INSERT INTO episodes(number_ep, img_ep, url_ep, fk_anime, version) " 
									 + "VALUES (%d, '%s', '%s', %d, '%s')", number_ep, img_ep, url_ep, fk_anime, version);
		try {
			statement.execute(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getAnimes() {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("select * from Anime");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	// Find Episodes from Animes
	public ResultSet getEp(String nome) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(
					"Select * from Anime, Episodes "
					+ "WHere fk_anime= id_anime and name_anime = '" + nome + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public void deletaAnime(String nome) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.execute("DELETE FROM Anime WHERE name_anime = '" + nome + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Delete all animes
	public void deletaAnime() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.execute("DELETE FROM Anime");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletaEp(String nome) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.execute("DELETE FROM Episodes WHere fk_anime = (select id_anime from Anime where name_anime ='"+ nome +"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// delete all episodes
	public void deletaEp() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.execute("DELETE FROM Episodes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			ds.getConnection().close();
			System.out.println("Conexão Finalizada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}