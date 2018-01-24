package com.wyj.dao;

import java.util.List;

import com.wyj.bean.Message;
import com.wyj.bean.Reply;
import com.wyj.util.Page;

public interface ReplyDAO {
	public void addReplay(Reply replay);			//��ӻظ�
	public List<Reply> findReplayByMsgID(int messageID,Page page);//������ID���һظ�
	public int findCountByMsgID(int messageID);//��ѯ��Ϣ�ظ���¼��
}
