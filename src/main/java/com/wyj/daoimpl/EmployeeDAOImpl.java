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
		// TODO �Զ����ɵķ������
		
	}

	public void updateEmployee(Employee employee) {
		// TODO �Զ����ɵķ������
		
	}

	public void deleteEmployee(int employeeID) {
		// TODO �Զ����ɵķ������
		
	}

	public List<Employee> findAllEmployee() {		
		return null;
	}

	public Employee findEmployeeById(int employeeID) {
		Connection conn = DBconnection.getConnection();		//������Ӷ���
		String findByIDSQL = "select * from " +
						"tb_employee where employeeID = ?";	//SQL���
		PreparedStatement pstmt = null;	//����Ԥ�������
		ResultSet rs = null;
		Employee employee = null;
		try {
			pstmt = conn.prepareStatement(findByIDSQL);		//���Ԥ������󲢸�ֵ
			pstmt.setInt(1, employeeID);					//���ò���
			rs = pstmt.executeQuery();						//ִ�в�ѯ
			if(rs.next()) {
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));		//����Ա�����
				employee.setEmployeeName(rs.getString(2));	//����Ա������
				employee.setEmployeeSex(rs.getBoolean(3));	//����Ա���Ա�
				employee.setEmployeeBirth(rs.getDate(4));	//���ó�������
				employee.setEmployeePhone(rs.getString(5));	//���ð칫�ҵ绰
				employee.setEmployeePlace(rs.getString(6));	//����סַ
				employee.setJoinTime(rs.getDate(7));		//����¼��ʱ��
				employee.setPassword(rs.getString(8));		//����ϵͳ����
				employee.setLead(rs.getBoolean(9));			//�����Ƿ�Ϊ������쵼
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBconnection.close(rs);								//�رս��������
			DBconnection.close(pstmt);							//�ر�Ԥ�������
			DBconnection.close(conn);							//�ر����Ӷ���
		}
		return employee;
	}
}
