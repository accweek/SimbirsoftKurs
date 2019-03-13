package com.simbirsoft.Loginovinternship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class LoginovInternshipApplication {

	public static void main(String[] args) throws  SQLException{
		final String user = "postgres";
		final String password = "1";
		final String url="jdbc:postgresql://localhost:5433/chat";

		final Connection connection = DriverManager.getConnection(url, user, password);

		try (PreparedStatement statement = connection.prepareStatement(sql: "SELECT * FROM user WHERE id = (?)")){

			statement.setInt(parameterIndex: 1, x: 1);
			final ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()){
				String byName = "login: " + resultSet.getString("login");
				String byIndex = "password:" + resultSet.getString(3);
				System.out.println(byName);
				System.out.println(byIndex);
			}
		}finally {connection.close();}
	}

}

