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
 * <p>Description: 管理员或各种用户登录后台</p>
 * @author Vico.Ho
 * @date 下午9:23:42
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后格式不一致的问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//前端输入的账号
		String account = request.getParameter("account");	
		//前端输入的密码
		String passW = request.getParameter("passWord");		
		
		// 用来记录从数据库中
		String passWord = null;
		
		// 构造职工对象
		Employee newEmployee = new Employee();
		// 设置职工的账号密码
		newEmployee.setAccount(account);
		newEmployee.setPassWord(passW);
		
		AccountManage accountManage = new AccountManage();
		// 找到了就返回1，找不到就返回0
		int result = accountManage.searchAccount(newEmployee);
		
		response.getWriter().println(result);
	}

	/**
	 * 调用get方法
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
