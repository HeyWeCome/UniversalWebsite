/**
 * 
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecificDao;
import entity.Message;
import service.message.MessageManage;
import util.DBUtil;

/** 
 * @ClassName:     HomePageInsertMessage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午7:43:10  
 */
public class HomePageInsertMessage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取到前台传过来的课程
		String courseName = request.getParameter("courseName");
		// 获取留言内容
		String content = request.getParameter("content");

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

		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间，也可使用当前时间戳
		String date = df.format(new Date());

		// 默认绑定管理员
		Integer employeeID = 10001;
		// 默认回复内容
		String reply = "待回复";
		String replyTime = date;

		Message message = new Message();
		message.setContent(content);
		message.setCourseID(courseID);
		message.setCreateTime(date);
		message.setEmployeeID(employeeID);
		message.setReplyTime(replyTime);
		message.setStatus("0");
		message.setReply(reply);

		MessageManage messageManage = new MessageManage();
		Integer result = messageManage.insertMessage(message);

		System.out.println("result:"+result);
		response.getWriter().println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
