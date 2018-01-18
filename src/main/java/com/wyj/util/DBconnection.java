package com.wyj.util;

import java.sql.Connection;			//���ݿ�����
import java.sql.DriverManager;      //��������
import java.sql.PreparedStatement;  //Ԥ����
import java.sql.ResultSet;			//�����
import java.sql.SQLException;		//�쳣

/*1��������Ӷ���
2�����Ԥ�������
3��ִ�в��� 
4���رս����   
5���ر�Ԥ�������   
6���ر����Ӷ���*/ 
public class DBconnection {
	private static final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/db_affairmanage";
	private static final String DBUSER="wyj";
	private static final String DBPASSWORD="20131983";

	public static Connection getConnection(){//����һ�����Ӷ���
		Connection conn = null;	
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}											
		  catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void close(Connection conn){//�ر����Ӷ���
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	
	public static void close(PreparedStatement pstmt){//�ر�Ԥ�������
		if(pstmt!=null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}
	
	public static void close(ResultSet rs){//�رս��������
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	}
}
