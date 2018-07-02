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
import service.message.MessageManage;
import util.DBUtil;

/** 
 * @ClassName:     DeleteMessage.java 
 * @Description:   删除留言  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 上午9:31:39  
 */
public class DeleteMessage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取留言内容
		String content = request.getParameter("content");	

		// 新建message对象
		Message message = new Message();
		message.setContent(content);

		// 新建message service类
		MessageManage messageManage = new MessageManage();
		Integer result = messageManage.deleteMessage(message);

		// 成功返回1  插入失败返回0
		response.getWriter().println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
