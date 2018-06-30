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
 * @ClassName:     UpdateAuditArticle.java 
 * @Description:   审核文章状态
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午2:43:13  
 */
public class UpdateAuditArticle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取文章名称
		String title = request.getParameter("title");	
		// 获取作者
		String author = request.getParameter("author");
		// 获取栏目名称
		String columnName = request.getParameter("columnName");
		// 获取状态
		String status = request.getParameter("status");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
