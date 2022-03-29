package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		

		Connection myCon=null;
		Statement myStmt=null;
		String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
		String user="root";
		String password="root";
		
		try{
			
			myCon=DriverManager.getConnection(url, user, password);
			
			System.out.println("Db Connected Successfully");
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		

	}

}
