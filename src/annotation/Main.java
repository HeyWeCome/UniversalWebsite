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

		// 新建人员对象
		Employee employee = new Employee();
		employee.setName("何玮康");
		employee.setAccount("superkang1");
		employee.setPassWord("123456");
		employee.setSex("男");
		employee.setRoleID(1);

		EmployeeManage employeeManage = new EmployeeManage();
		Integer result = employeeManage.insertEmployee(employee);
		System.out.println(result);
	}}
