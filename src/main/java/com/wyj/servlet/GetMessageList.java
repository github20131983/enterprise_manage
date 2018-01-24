package com.wyj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyj.bean.Message;
import com.wyj.dao.MessageDAO;
import com.wyj.factory.MessageDAOFactory;
import com.wyj.util.Page;
import com.wyj.util.PageUtil;

public class GetMessageList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		
		MessageDAO messageDAO = MessageDAOFactory.getMessageAOInstance();
		Page page = PageUtil.creatPage(5, messageDAO.findAllCount(), currentPage);
		List<Message> messages = messageDAO.findAllMessagee(page);
		request.setAttribute("messageList", messages);
		request.setAttribute("page", page);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = servletContext.
					getRequestDispatcher("/msgList.jsp");	//跳转到消息列表页
		dispatcher.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
