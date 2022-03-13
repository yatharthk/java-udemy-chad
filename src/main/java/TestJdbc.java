
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jdbcUrl="jdbc:mysql://localhost:3306/spring_security_demo_plaintext?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String user="root";
		String passsword="root";
		try 
		{
			System.out.println("Connecting to database"+jdbcUrl);
			Connection myCon=DriverManager.getConnection(jdbcUrl,user,passsword);
			System.out.println("Connection successful!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}