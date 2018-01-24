package com.wyj.factory;

import com.wyj.dao.CriticismDAO;
import com.wyj.daoimpl.CriticismDAOImpl;

public class CriticismDAOFactory {
	public static CriticismDAO getCriticismDAOInstance(){	//������������������DAOʵ����ʵ��
		return new CriticismDAOImpl();						//����DAOʵ����ʵ��
	}
}
