package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.account.AccountManage;

/**
 * 
 * @ClassName:     Login.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 上午10:58:19
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取账号
		String account = request.getParameter("account");	
		// 获取密码
		String passW = request.getParameter("passWord");		
		
		// 从数据库中查询到的密码
		String passWord = null;
		
		// 新建员工对象
		Employee newEmployee = new Employee();
		// 设置账号密码
		newEmployee.setAccount(account);
		newEmployee.setPassWord(passW);
		
		AccountManage accountManage = new AccountManage();
		// 获取返回的结果
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
