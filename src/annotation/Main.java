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
		// 获取人员名
		String name = "何玮康";	
		// 获取性别
		String sex = "男";
		// 获取账号
		String account = "superkang";
		// 获取密码
		String passWord = "123456";
		// 获取角色名
		String roleName = "超级管理员";

		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(roleName, "role");
		System.out.println(sql1);
		Integer roleID = 0;
		try {
			roleID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建人员对象
		Employee employee = new Employee();
		employee.setName(name);
		employee.setAccount(account);
		employee.setPassWord(passWord);
		employee.setSex(sex);
		employee.setRoleID(roleID);

		EmployeeManage employeeManage = new EmployeeManage();
		Integer result = employeeManage.updateEmployee(employee);
		System.out.println(result);
	}}
