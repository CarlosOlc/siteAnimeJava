package com.cyberanimes.testes;

import java.sql.*;

import org.sqlite.SQLiteDataSource;

public class SQLiteJDBCDriverConnection {
	SQLiteDataSource ds = null;

	public void connect(String name, String link, String img) {

		try {
			ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\carlos\\eclipse-workspace\\site\\BancoAnimes.db");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection connection = ds.getConnection()) {
			// ----------------

			System.out.println("Conexão realizada !!!!");

			Statement statement = connection.createStatement();

			// inserindo registros
			String command = String.format(
					"INSERT INTO Anime(name_anime, url_anime, img_anime) " 
							+ "VALUES ('%s','%s','%s')", name, link, img);

			statement.execute(command);

			// deletar registro
//		    statement.execute("DELETE FROM Anime WHERE name_anime = 'Carlos'");

			// lendo os registros
			PreparedStatement stmt = connection.prepareStatement("select * from Anime");
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id_anime");
				String nome = resultSet.getString("name_anime");

				System.out.println(id + " - " + nome);
			}

			// ----------------
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//
//	public static void main(String[] args) {
//		connect("oi");
//	}

}