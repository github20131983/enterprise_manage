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
		ServletContext servletContext = getServletContext();	//获得ServletContex
		RequestDispatcher dispatcher = null;					
		String employeeID = request.getParameter("employeeID");	//接受员工编号参数
		String password = request.getParameter("password");		//接受系统密码参数
		if(employeeID == null || "".equals(employeeID)) {		//判断是否输入员工编号
			request.setAttribute("error", "请输入员工编号!");
			dispatcher = servletContext.
					getRequestDispatcher("/login.jsp");//设置跳转页面
		}else {
			if(password == null || "".equals(password)) {		//判断是否输入系统密码
				request.setAttribute("error", "请输入系统口令!");
				dispatcher = servletContext.
					getRequestDispatcher("/login.jsp");//设置跳转页面
			}else {
				EmployeeDAO employeeDAO = 
					EmployeeDAOFactory.getEmployeeDAOInstance();//获得DAO实现类实例
				Employee employee = employeeDAO.
					findEmployeeById(Integer.parseInt(employeeID));//查询员工
				if(employee == null) {
					request.setAttribute("error", "该员工编号不存在!");
					dispatcher = servletContext.
						getRequestDispatcher("/login.jsp");
				} else {
					if(password.equals(employee.getPassword())) {
						request.getSession().
							setAttribute("employee", employee);//将员工信息保存到session范围
						response.sendRedirect("index.jsp");
						return;
					} else {
						request.setAttribute("error", "系统口令不正确!");
						dispatcher = servletContext.
							getRequestDispatcher("/login.jsp");
					}
				}
			}
		}
		dispatcher.forward(request, response);//进行跳转
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
