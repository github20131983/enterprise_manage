package com.wyj.dao;

import java.util.List;

import com.wyj.bean.Criticism;
import com.wyj.bean.Reply;
import com.wyj.util.Page;

public interface CriticismDAO {
	public void addCriticism(Criticism criticism);			//添加批复
	public Criticism findCriticismByMsgID(int messageID);	//按文章ID查找批复
}
