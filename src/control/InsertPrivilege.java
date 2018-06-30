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

import entity.Permisson;

/** 
 * @ClassName:     InsertPrivilege.java 
 * @Description:   插入权限  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午10:33:38  
 */
public class InsertPrivilege extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取角色ID
		String roleID = request.getParameter("roleID");	
		// 获取模块ID
		String moduleID = request.getParameter("moduleID");
		
		// 新建permission对象
		Permisson permission = new Permisson();
		permission.setId(Integer.parseInt(roleID));
		permission.setModuleID(Integer.parseInt(moduleID));
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
