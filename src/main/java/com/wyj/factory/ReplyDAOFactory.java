package com.wyj.factory;

import com.wyj.dao.ReplyDAO;
import com.wyj.daoimpl.ReplyDAOImpl;

public class ReplyDAOFactory {
	public static ReplyDAO getReplyDAOInstance(){	//������������������DAOʵ����ʵ��
		return new ReplyDAOImpl();						//����DAOʵ����ʵ��
	}
}
