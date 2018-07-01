/**
 * 
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecificDao;
import entity.Article;
import entity.Employee;
import service.article.ArticleManage;
import service.employee.EmployeeManage;
import util.DBUtil;

/** 
 * @ClassName:     UpdateEmployee.java 
 * @Description:   更新人员 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午2:41:21  
 */
public class UpdateEmployee extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取人员名
		String name = request.getParameter("name");	
		// 获取性别
		String sex = request.getParameter("sex");
		// 获取账号
		String account = request.getParameter("account");
		// 获取密码
		String passWord = request.getParameter("passWord");
		// 获取角色名
		String roleName = request.getParameter("roleName");

		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(roleName, "role");
		System.out.println(sql1);
		Integer roleID = 0;
		try {
			roleID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建人员对象
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAccount(account);
		employee.setPassWord(passWord);
		employee.setSex(sex);
		employee.setRoleID(roleID);

		EmployeeManage employeeManage = new EmployeeManage();
		Integer result = employeeManage.updateEmployee(employee);
		// 成功返回1  插入失败返回0
		response.getWriter().println(result);
		System.out.println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
