package com.wyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyj.bean.Employee;
import com.wyj.bean.Message;
import com.wyj.bean.Reply;
import com.wyj.dao.MessageDAO;
import com.wyj.dao.ReplyDAO;
import com.wyj.factory.MessageDAOFactory;
import com.wyj.factory.ReplyDAOFactory;

public class CommitReply extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");//���ò��������ʽ
	String replyContent = request.
				getParameter("replyContent");//�������Ļظ�����
	int messageID = Integer.parseInt(
			request.getParameter("messageID"));//�����Ϣ���
	ServletContext servletContext = getServletContext();
	RequestDispatcher dispatcher = null;
	//���ĸ�Ա�������Ļظ�
	Employee employee = (Employee) request.getSession().getAttribute("employee");
	if(employee == null) {
		request.setAttribute("error", "Ҫ���лظ��������Ƚ������ʶ��");
		
	}else {
		if(replyContent == null || "".equals(replyContent)) { //����û�û���������
			request.setAttribute("error", "��������ظ�����");
		}else {
			Reply replay = new Reply();
			replay.setReplyContent(replyContent);//���ûظ�����
			replay.setMessageID(messageID);		//������Ϣ���
			replay.setEmployeeID(employee.getEmployeeID());//���ûظ���
			replay.setReplyTime(new Date());	//���ûظ�ʱ��
			ReplyDAO replayDAO = ReplyDAOFactory.getReplyDAOInstance();
			replayDAO.addReplay(replay);		//�����Ϣ�ظ������
		}
	}
	dispatcher = servletContext.getRequestDispatcher(
				"/GetMessage?messageID=" + messageID);//��ת����Ϣ�鿴ҳ
	dispatcher.forward(request, response);
}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
