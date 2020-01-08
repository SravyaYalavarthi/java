package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Qualification;

@Repository
public class QualificationDAO {
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
	public String adddata(Qualification qua) {
		System.out.println(qua);
		//step3 create a statement
	try {
		Connection con=connectToDB();
		PreparedStatement stmt=con.prepareStatement("insert into qualification1 values(?,?,?,?,?)");
		stmt.setString(1, qua.getQualification());
		stmt.setInt(2,qua.getFinalPercentage());
		stmt.setInt(3, qua.getInterviewScore());
		stmt.setInt(4, qua.getCommunicationScore());
		stmt.setInt(5,qua.getTechnicalScore());
		//step4 execute sql query
		int affectedRows=stmt.executeUpdate();
		System.out.println("affectedRows="+affectedRows);
		con.close();
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "data inserted successfully";
	}
	public ArrayList<Qualification> display() {
		// TODO Auto-generated method stub
		ArrayList<Qualification> list=new ArrayList<Qualification>();
		try {
		Connection con=connectToDB();
		PreparedStatement stmt=con.prepareStatement("select * from qualification1");
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()){  
			Qualification qua1=new Qualification(); 
			qua1.setQualification(rs.getString(1));
			qua1.setFinalPercentage(rs.getInt(2));
			qua1.setInterviewScore(rs.getInt(3));
			qua1.setCommunicationScore(rs.getInt(4));
			qua1.setTechnicalScore(rs.getInt(5));
				list.add(qua1);
		}
		con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return list;

	}
	





}
