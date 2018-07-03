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
		// 获取模块名
		String name = "数据结构首页";	
		// 获取父模块名
		String parentColumnName = "已是上级栏目";

		if(parentColumnName.equals("已是上级栏目")){
			// 新建子模块对象
			Columns columns = new Columns();
			columns.setName(name);
			columns.setLevel("0");

			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.insertColumn(columns);
//			response.getWriter().println(result);

		}else{
			// 根据用户名查询用户ID
			String sql1 = SpecificDao.findIDFromTable(parentColumnName, "columns");
			System.out.println(sql1);
			Integer parentColumnsID = 0;
			try {
				parentColumnsID = DBUtil.findID(sql1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 新建子栏目对象
			SonColumns sonColumns = new SonColumns();
			sonColumns.setName(name);
			sonColumns.setParentID(parentColumnsID);
			sonColumns.setLevel("1");

			ColumnsManage columnsManage = new ColumnsManage();
			Integer result = columnsManage.insertSonColumns(sonColumns);

//			response.getWriter().println(result);
		}
	}
}
