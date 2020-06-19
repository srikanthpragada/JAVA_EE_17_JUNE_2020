package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectionWithAutoClose {

	public static void main(String[] args) throws Exception {
		// ARM or try with resources 
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql")) {
			System.out.println("Connected To HR Database of MySQL!");
		}
	}
}
