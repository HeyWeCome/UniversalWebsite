/**
 * 
 */
package annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import dao.SpecificDao;
import entity.Article;
import entity.Columns;
import entity.CourseColumns;
import entity.Employee;
import entity.Message;
import entity.Module;
import entity.Permission;
import entity.Role;
import entity.SonColumns;
import entity.SonModule;
import service.CourseColumns.CourseColumnsManage;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.course.CourseManage;
import service.employee.EmployeeManage;
import service.message.MessageManage;
import service.module.ModuleManage;
import service.permission.PermissionManage;
import service.role.RoleManage;
import util.DBUtil;

/**
 * 
 * @ClassName:     Main.java 
 * @Description:   测试类记得删除
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:56:50
 */
public class Main {
	public static void main(String[] args){
		// 获取到前台传过来的课程
		String courseName = "数据结构";

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

		// 获取留言内容
		String content = "怎么才能找到女朋友？";
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
	}
}
