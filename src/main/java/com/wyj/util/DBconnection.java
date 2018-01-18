package com.wyj.util;

import java.sql.Connection;			//数据库连接
import java.sql.DriverManager;      //驱动管理
import java.sql.PreparedStatement;  //预处理
import java.sql.ResultSet;			//结果集
import java.sql.SQLException;		//异常

/*1、获得连接对象
2、获得预处理对象
3、执行操作 
4、关闭结果集   
5、关闭预处理对象   
6、关闭连接对象*/ 
public class DBconnection {
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/db_affairmanage";
	private static final String DBUSER="wyj";
	private static final String DBPASSWORD="20131983";

	public static Connection getConnection(){//声明一个连接对象
		Connection conn = null;	
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}											
		  catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void close(Connection conn){//关闭连接对象
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	
	public static void close(PreparedStatement pstmt){//关闭预处理对象
		if(pstmt!=null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	
	public static void close(ResultSet rs){//关闭结果集对象
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
}
