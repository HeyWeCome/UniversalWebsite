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
import entity.Permission;
import entity.Role;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.employee.EmployeeManage;
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

		// 获取角色ID
		String roleID = "1";	
		// 获取模块ID
		String moduleID = "10000";

		// 新建permission对象
		Permission permission = new Permission();
		permission.setRoleID(Integer.parseInt(roleID));
		permission.setModuleID(Integer.parseInt(moduleID));

		PermissionManage permissionManage = new PermissionManage();
		Integer result = permissionManage.insertPermission(permission);

		// 插入成功返回1  插入失败返回0
//		response.getWriter().println(result);
		System.out.println(result);
	}}
