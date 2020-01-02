package com.deloitte.library.dao;
import java.sql.*;

import com.deloitte.library.model.Books;
public class BooksDAO {
	public static Connection connectToDB() {
		Connection connection=null;
		try {
			//step1 register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step2 create connection
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}
public static void addbook(Books book ) {
	System.out.println(book);
	//step3 create a statement
try {
	Connection con=connectToDB();
	PreparedStatement stmt=con.prepareStatement("insert into book values(?,?,?,?)");
	stmt.setInt(1,book.getBookid());
	stmt.setString(2, book.getBookname());
	stmt.setString(3, book.getBookauthor());
	stmt.setInt(4, book.getBookprice());
	
	//step4 execute sql query
	int affectedRows=stmt.executeUpdate();
	System.out.println("affectedRows="+affectedRows);
	ResultSet rs=stmt.executeQuery("select * from book");  
	while(rs.next()){  
	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));  
	con.close();
	}
	}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
