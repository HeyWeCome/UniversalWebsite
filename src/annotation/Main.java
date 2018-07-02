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
		String content = "何玮康最帅";	

		// 新建message对象
		Message message = new Message();
		message.setContent(content);

		// 新建message service类
		MessageManage messageManage = new MessageManage();
		Integer result = messageManage.deleteMessage(message);
		System.out.println(result);
	}}
