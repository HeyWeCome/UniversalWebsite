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
import entity.Employee;
import entity.Message;
import entity.Module;
import entity.Permission;
import entity.Role;
import entity.SonColumns;
import entity.SonModule;
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
		// 获取栏目名
		String name = "咔咔咔";	
		// 获取父栏目名
		String parentColumnName = "ddd";

		if(parentColumnName.equals("已是上级栏目")){
			// 新建子模块对象
			Columns columns = new Columns();
			columns.setName(name);
			// 新建管理对象
			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.deleteColumns(columns);
//			response.getWriter().println(result);
		}else{
			// 新建子栏目对象
			SonColumns sonColumns = new SonColumns();
			sonColumns.setName(name);
			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.deleteSonColumns(sonColumns);
//			response.getWriter().println(result);
		}
	}
}
