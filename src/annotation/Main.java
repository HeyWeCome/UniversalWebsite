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
		// 获取到课程传递过来的子栏目的ID
				Integer courseSonColumnsId = 10001;
				
				SonColumns soncolumns = new SonColumns();
				soncolumns.setId(courseSonColumnsId);
				
				ColumnsManage manage = new ColumnsManage();
				String result = manage.findAllArticle(soncolumns);
				
				if(!result.isEmpty()){
					JSONArray fromObject = (JSONArray) JSON.parse(result);
					System.out.println("couserSonColumns are:"+fromObject.toString());
//					response.getWriter().print(fromObject);
				}else{
//					response.getWriter().print(""); 
				}
	}
}
