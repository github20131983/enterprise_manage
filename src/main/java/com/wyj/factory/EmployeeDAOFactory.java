package com.wyj.factory;

import com.wyj.dao.EmployeeDAO;
import com.wyj.daoimpl.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){	//������������������DAOʵ����ʵ��
		return new EmployeeDAOImpl();						//����DAOʵ����ʵ��
	}
}
