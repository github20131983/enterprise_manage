package com.wyj.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyj.bean.Employee;
import com.wyj.dao.EmployeeDAO;
import com.wyj.factory.EmployeeDAOFactory;

/**
 * Servlet implementation class StatusRecognise
 */
public class StatusRecognise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusRecognise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();	//���ServletContex
		RequestDispatcher dispatcher = null;					
		String employeeID = request.getParameter("employeeID");	//����Ա����Ų���
		String password = request.getParameter("password");		//����ϵͳ�������
		if(employeeID == null || "".equals(employeeID)) {		//�ж��Ƿ�����Ա�����
			request.setAttribute("error", "������Ա�����!");
			dispatcher = servletContext.
					getRequestDispatcher("/login.jsp");//������תҳ��
		}else {
			if(password == null || "".equals(password)) {		//�ж��Ƿ�����ϵͳ����
				request.setAttribute("error", "������ϵͳ����!");
				dispatcher = servletContext.
					getRequestDispatcher("/login.jsp");//������תҳ��
			}else {
				EmployeeDAO employeeDAO = 
					EmployeeDAOFactory.getEmployeeDAOInstance();//���DAOʵ����ʵ��
				Employee employee = employeeDAO.
					findEmployeeById(Integer.parseInt(employeeID));//��ѯԱ��
				if(employee == null) {
					request.setAttribute("error", "��Ա����Ų�����!");
					dispatcher = servletContext.
						getRequestDispatcher("/login.jsp");
				} else {
					if(password.equals(employee.getPassword())) {
						request.getSession().
							setAttribute("employee", employee);//��Ա����Ϣ���浽session��Χ
						response.sendRedirect("index.jsp");
						return;
					} else {
						request.setAttribute("error", "ϵͳ�����ȷ!");
						dispatcher = servletContext.
							getRequestDispatcher("/login.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);//������ת
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
