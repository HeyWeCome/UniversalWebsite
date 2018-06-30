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

import entity.Permission;
import entity.Role;
import service.permission.PermissionManage;
import service.role.RoleManage;

/** 
 * @ClassName:     InsertRole.java 
 * @Description:   新增角色 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午11:07:19  
 */
public class InsertRole extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取角色ID
		String name = request.getParameter("name");	
		// 获取角色描述
		String description = request.getParameter("description");

		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间，也可使用当前时间戳
		String date = df.format(new Date());
		
		// 新建Role对象
		Role role = new Role();
		role.setName(name);
		role.setDescription(description);
		role.setCreateTime(date);

		RoleManage roleManage = new RoleManage();
		Integer result = roleManage.insertRole(role);

		// 插入成功返回1  插入失败返回0
		response.getWriter().println(result);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
