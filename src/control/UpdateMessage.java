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
 * @ClassName:     UpdateMessage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午8:04:56  
 */
public class UpdateMessage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");


		// 获取留言内容
		String content = request.getParameter("content");	
		// 获取留言的时间
		String createTime = request.getParameter("createTime");
		// 获取回复的员工名
		String replyEmployee = request.getParameter("replyEmployee");
		// 获取回复的内容
		String replyContent = request.getParameter("replyContent");
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间，也可使用当前时间戳
		String date = df.format(new Date());

		// 根据员工名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(replyEmployee, "employee");
		System.out.println(sql1);
		Integer replyEmployeeID = null;
		try {
			replyEmployeeID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建message对象
		Message message = new Message();
		message.setContent(content);
		message.setCreateTime(createTime);
		message.setEmployeeID(replyEmployeeID);
		message.setReply(replyContent);
		message.setReplyTime(date);
		message.setStatus("1");
		
		// 新建message管理类
		MessageManage messageManage = new MessageManage();
		Integer result = messageManage.updateMessage(message);
		
		// 成功返回1  插入失败返回0
		response.getWriter().println(result);
				

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
