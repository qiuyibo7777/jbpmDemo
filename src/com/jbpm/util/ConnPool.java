package com.jbpm.util;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnPool {

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 conn = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:BSOA","JBPM","JBPM");
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			conn = java.sql.DriverManager.getConnection("jdbc:sqlserver://172.16.40.5:1433;DatabaseName=dev_his","sa","bsoft");
		 return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
