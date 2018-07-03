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

import dao.SpecificDao;
import entity.CourseColumns;
import service.CourseColumns.CourseColumnsManage;
import util.DBUtil;

/** 
 * @ClassName:     HomePageFindAllSonColumns.java 
 * @Description:   找到给定课程对呀的所有子栏目
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午2:34:29  
 */
public class HomePageFindAllSonColumns extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取到前台传过来的课程
		String courseName = request.getParameter("courseName");
		// 获取到前台传过来的父栏目的名称
		String parentColumnsName = request.getParameter("parentColumnsName");

		if(parentColumnsName.equals("课程介绍")){
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

			// 根据父栏目名查询父栏目ID
			String sql2 = SpecificDao.findIDFromTable(parentColumnsName, "columns");

			Integer columnsID = 0;
			try {
				columnsID = DBUtil.findID(sql2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			CourseColumns courseColumns = new CourseColumns();
			
			courseColumns.setColumnsID(columnsID);
			courseColumns.setCourseID(courseID);
			
			CourseColumnsManage manage = new CourseColumnsManage();
			String result = manage.findSoncolumns(courseColumns);
			
			if(!result.isEmpty()){
				JSONArray fromObject = (JSONArray) JSON.parse(result);
				System.out.println("couserSonColumns are:"+fromObject.toString());
				response.getWriter().print(fromObject);
			}else{
				response.getWriter().print(""); 
			}
			
		}else{
			response.getWriter().print("");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
