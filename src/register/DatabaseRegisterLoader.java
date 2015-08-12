package register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseRegisterLoader implements Registerable {

	public static final String URL = "jdbc:mysql://localhost/register";
	public static final String USER = "root";
	public static final String PASSWORD = "admin";
	public static final String QUERYDELETE = "DELETE FROM register";
	public static final String QUERYINSERT = "INSERT INTO register (id, name, phonenumber) VALUES (?, ?, ?)";
	public static final String QUERYSELECT = "SELECT id, name, phonenumber FROM register";

	@Override
	public void writeRegister(Register register) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement stmt = con.createStatement();
		// final String QUERYCREATE = "CREATE TABLE register (id INT PRIMARY
		// KEY, name VARCHAR(32) NOT NULL, phonenumber VARCHAR(10) NOT NULL)";
		stmt.executeUpdate(QUERYDELETE);
		stmt.close();
		PreparedStatement pstmt = con.prepareStatement(QUERYINSERT);
		int count = register.getCount();
		for (int i = 0; i < count; i++) {
			pstmt.setInt(1, i + 1);
			pstmt.setString(2, register.getPerson(i).getName());
			pstmt.setString(3, register.getPerson(i).getPhoneNumber());
			pstmt.executeUpdate();
		}
		pstmt.close();
		con.close();
	}

	@Override
	public Register registerLoad() throws SQLException {
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(QUERYSELECT)){
			Register register=new ListRegister();
			while(rs.next()) {
				register.addPerson(new Person(rs.getString(2),rs.getString(3)));
	        }
			return register;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public void registerFill(Register register) {
		// TODO Auto-generated method stub

	}

}
