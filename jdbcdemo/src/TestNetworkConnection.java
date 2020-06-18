import java.sql.Connection;
import java.sql.DriverManager;

public class TestNetworkConnection {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/c:\\classroom\\derby\\hr");
		System.out.println("Connected To Derby Database!");
		con.close();
	}

}
