package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JobBean {
	private String id, title;
	private int minsal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}

	public void add() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); // Load JDBC Driver
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "mysql")) {
			PreparedStatement ps = con.prepareStatement("insert into jobs values(?,?,?)");
			ps.setString(1, id);
			ps.setString(2, title);
			ps.setInt(3, minsal);
			ps.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
			throw ex;
		}
	}

	public String getMessage() {
		try {
			add();
			return "Successfully added job";
		} catch (Exception ex) {
			return "Error! Could not add job!";
		}
	}

}
