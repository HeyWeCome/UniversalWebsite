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

/** 
 * @ClassName:     UpdateModule.java 
 * @Description:   更新模块  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午4:10:40  
 */
public class UpdateModule extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决乱码
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 获取父模块名
		String parentName = request.getParameter("parentName");
		// 获取子模块名
		String sonName = request.getParameter("sonName");
		// 获取父模块状态
		String parentStatus = request.getParameter("parentStatus");
		// 获取子模块状态
		String sonStatus = request.getParameter("sonStatus");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
