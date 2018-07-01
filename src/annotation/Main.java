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
import entity.Employee;
import entity.Message;
import entity.Permission;
import entity.Role;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
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
		// 获取留言内容
		String content ="如何下载sql？";	
		// 获取留言的时间
		String createTime = "2018-07-27 16:45:43";
		// 获取回复的员工名
		String replyEmployee = "何玮康";
		// 获取回复的内容
		String replyContent = "哈哈哈哈哈哈";
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
		System.out.println(result);
	}}
