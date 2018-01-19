package com.wyj.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wyj.bean.Employee;
import com.wyj.dao.EmployeeDAO;
import com.wyj.util.DBconnection;

public class EmployeeDAOImpl implements EmployeeDAO{

	public void addEmployee(Employee employee) {
		// TODO 自动生成的方法存根
		
	}

	public void updateEmployee(Employee employee) {
		// TODO 自动生成的方法存根
		
	}

	public void deleteEmployee(int employeeID) {
		// TODO 自动生成的方法存根
		
	}

	public List<Employee> findAllEmployee() {		
		return null;
	}

	public Employee findEmployeeById(int employeeID) {
		Connection conn = DBconnection.getConnection();		//获得连接对象
		String findByIDSQL = "select * from " +
						"tb_employee where employeeID = ?";	//SQL语句
		PreparedStatement pstmt = null;	//声明预处理对象
		ResultSet rs = null;
		Employee employee = null;
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//获得预处理对象并赋值
			pstmt.setInt(1, employeeID);					//设置参数
			rs = pstmt.executeQuery();						//执行查询
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));		//设置员工编号
				employee.setEmployeeName(rs.getString(2));	//设置员工姓名
				employee.setEmployeeSex(rs.getBoolean(3));	//设置员工性别
				employee.setEmployeeBirth(rs.getDate(4));	//设置出生日期
				employee.setEmployeePhone(rs.getString(5));	//设置办公室电话
				employee.setEmployeePlace(rs.getString(6));	//设置住址
				employee.setJoinTime(rs.getDate(7));		//设置录入时间
				employee.setPassword(rs.getString(8));		//设置系统口令
				employee.setLead(rs.getBoolean(9));			//设置是否为管理层领导
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(rs);								//关闭结果集对象
			DBconnection.close(pstmt);							//关闭预处理对象
			DBconnection.close(conn);							//关闭连接对象
		}
		return employee;
	}
}
