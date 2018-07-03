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
		// 获取到前台传过来的父栏目的名称
		String parentColumnsName = "课程介绍";

		if(parentColumnsName.equals("课程介绍")){
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

			// 根据父栏目名查询父栏目ID
			String sql2 = SpecificDao.findIDFromTable(parentColumnsName, "columns");

			Integer columnsID = 0;
			try {
				columnsID = DBUtil.findID(sql2);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			CourseColumns courseColumns = new CourseColumns();

			courseColumns.setColumnsID(columnsID);
			courseColumns.setCourseID(courseID);

			CourseColumnsManage manage = new CourseColumnsManage();
			String result = manage.findSoncolumns(courseColumns);
			System.out.println(result.toString());
		}
	}
}
