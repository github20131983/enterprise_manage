package com.wyj.dao;

import java.util.List;

import com.wyj.bean.Criticism;
import com.wyj.bean.Reply;
import com.wyj.util.Page;

public interface CriticismDAO {
	public void addCriticism(Criticism criticism);			//�������
	public Criticism findCriticismByMsgID(int messageID);	//������ID��������
}
