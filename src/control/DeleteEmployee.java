/**
 * 
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;

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
 * @ClassName:     DeleteEmployee.java 
 * @Description:   删除人员 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午12:56:30  
 */
public class DeleteEmployee extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取员工的账号
		String account = request.getParameter("account");	
		// 获取人员名
		String name = request.getParameter("name");	
		
		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(name, "employee");
		Integer employeeID = null;

		try {
			employeeID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建文章对象
		Employee employee = new Employee();
		// 设置员工名
		employee.setName(name);
		// 设置员工账号
		employee.setAccount(account);
		
		EmployeeManage employeeManage = new EmployeeManage();

		// 删除成功返回1 删除失败返回0
		Integer result = employeeManage.deleteEmployee(employee);

		response.getWriter().println(result);
		System.out.println("删除的结果为:"+result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
