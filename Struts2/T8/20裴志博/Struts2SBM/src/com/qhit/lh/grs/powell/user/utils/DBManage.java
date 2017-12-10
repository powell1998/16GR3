package com.qhit.lh.grs.powell.user.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManage {
	
	public static Connection con;
	public static String DriverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url="jdbc:sqlserver://localhost:1433;databaseName=db_sbm";
	public static String user="sa";
	public static String password="123456";
	
	public static Connection getConnection(){
		try {
			Class.forName(DriverName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭连接
	public static void close(Connection con){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
