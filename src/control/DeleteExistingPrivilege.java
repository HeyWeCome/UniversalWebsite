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

import entity.Permission;
import entity.Role;
import service.permission.PermissionManage;

/** 
 * @ClassName:     DeleteExistingPrivilege.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午1:32:33  
 */
public class DeleteExistingPrivilege extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 获取员工的ID
		String roleID = request.getParameter("roleID");	
		
		// 新增角色对象
		Permission permission = new Permission();
		permission.setRoleID(Integer.parseInt(roleID));
		
		PermissionManage permissionManage = new PermissionManage();
		Integer result = permissionManage.deleteExistingPermission(permission);
		
		response.getWriter().println(result);
		System.out.println("删除的结果为:"+result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
