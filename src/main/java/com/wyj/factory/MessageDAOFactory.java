package com.wyj.factory;

import com.wyj.dao.MessageDAO;
import com.wyj.daoimpl.MessageDAOImpl;

public class MessageDAOFactory {
	public static MessageDAO getMessageAOInstance(){	//������������������DAOʵ����ʵ��
		return new MessageDAOImpl();						//����DAOʵ����ʵ��
	}
}
