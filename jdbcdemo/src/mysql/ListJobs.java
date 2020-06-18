package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","mysql");
        
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jobs");
		while(rs.next()) {
			System.out.println(rs.getString("title"));
		}

		con.close();
	}

}
