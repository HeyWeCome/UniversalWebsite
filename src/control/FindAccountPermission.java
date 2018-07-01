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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Permission;
import service.permission.PermissionManage;

/** 
 * @ClassName:     FindAccountPermission.java 
 * @Description:   勾选用户已有的权限  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午1:58:22  
 */
public class FindAccountPermission extends HttpServlet {


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
		String result = permissionManage.findAllOwnPermission(permission);
		
		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("已有权限为:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
