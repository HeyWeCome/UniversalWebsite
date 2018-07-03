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

import entity.Columns;
import entity.SonColumns;
import service.columns.ColumnsManage;

/** 
 * @ClassName:     DeleteColumns.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 上午10:30:51  
 */
public class DeleteColumns extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取栏目名
		String name = request.getParameter("name");	
		// 获取父栏目名
		String parentColumnName = request.getParameter("parentColumnName");

		if(parentColumnName.equals("已是上级栏目")){
			// 新建子模块对象
			Columns columns = new Columns();
			columns.setName(name);
			// 新建管理对象
			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.deleteColumns(columns);
			response.getWriter().println(result);
		}else{
			// 新建子栏目对象
			SonColumns sonColumns = new SonColumns();
			sonColumns.setName(name);
			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.deleteSonColumns(sonColumns);
			response.getWriter().println(result);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
