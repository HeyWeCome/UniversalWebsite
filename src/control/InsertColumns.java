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
import entity.Columns;
import entity.Module;
import entity.SonColumns;
import entity.SonModule;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
import util.DBUtil;

/** 
 * @ClassName:     InsertColumns.java 
 * @Description:   新增栏目 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 上午12:08:01  
 */
public class InsertColumns extends HttpServlet {

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
			columns.setLevel("0");

			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.insertColumn(columns);
			response.getWriter().println(result);

		}else{
			// 根据用户名查询用户ID
			String sql1 = SpecificDao.findIDFromTable(parentColumnName, "columns");
			System.out.println(sql1);
			Integer parentColumnsID = 0;
			try {
				parentColumnsID = DBUtil.findID(sql1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 新建子栏目对象
			SonColumns sonColumns = new SonColumns();
			sonColumns.setName(name);
			sonColumns.setParentID(parentColumnsID);
			sonColumns.setLevel("1");
			
			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.insertSonColumns(sonColumns);

			response.getWriter().println(result);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
