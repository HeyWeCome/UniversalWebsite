package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.AccountManage;

/**
 * 
 * <p>Title: Login</p>
 * <p>Description: ����Ա������û���¼��̨</p>
 * @author Vico.Ho
 * @date ����9:23:42
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ǰ���ʽ��һ�µ�����
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//ǰ��������˺�
		String account = request.getParameter("account");	
		//ǰ�����������
		String passW = request.getParameter("passWord");		
		
		// ������¼�����ݿ���
		String passWord = null;
		
		// ����ְ������
		Employee newEmployee = new Employee();
		// ����ְ�����˺�����
		newEmployee.setAccount(account);
		newEmployee.setPassWord(passW);
		
		AccountManage accountManage = new AccountManage();
		// �ҵ��˾ͷ���1���Ҳ����ͷ���0
		int result = accountManage.searchAccount(newEmployee);
		
		response.getWriter().println(result);
	}

	/**
	 * ����get����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
