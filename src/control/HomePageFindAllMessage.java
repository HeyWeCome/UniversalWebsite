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
import entity.Message;
import util.DBUtil;

/** 
 * @ClassName:     HomePageFindAllMessage.java 
 * @Description:   门户网站查看所有的留言 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午5:21:16  
 */
public class HomePageFindAllMessage extends HttpServlet {


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
		
		Message message = new Message();
		message.setCourseID(courseID);
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
