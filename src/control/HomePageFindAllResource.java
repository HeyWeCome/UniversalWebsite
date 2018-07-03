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
import entity.CourseColumns;
import service.CourseColumns.CourseColumnsManage;
import util.DBUtil;

/** 
 * @ClassName:     HomePageFindAllResource.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午3:16:25  
 */
public class HomePageFindAllResource extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取到前台传过来的课程
		String courseName = request.getParameter("courseName");

		// 根据课程名查询课程ID
		String sql1 = SpecificDao.findIDFromTable(courseName, "course");

		Integer courseID = 0;
		try {
			courseID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 新建课程栏目对象
		CourseColumns courseColumns = new CourseColumns();
		
		courseColumns.setCourseID(courseID);
		
		CourseColumnsManage manage = new CourseColumnsManage();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
