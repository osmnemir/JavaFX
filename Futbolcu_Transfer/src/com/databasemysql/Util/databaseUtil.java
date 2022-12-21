package com.databasemysql.Util;


import java.sql.*;

public class databaseUtil {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/futboldb","root","mysql");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
		 
	}
}
