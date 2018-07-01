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

		// 获取员工的账号
				String account = "superkang1";
				// 获取人员名
				String name ="何玮康";	
				
				// 根据用户名查询用户ID
				String sql1 = SpecificDao.findIDFromTable(name, "employee");
				Integer employeeID = null;

				try {
					employeeID = DBUtil.findID(sql1);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 新建文章对象
				Employee employee = new Employee();
				// 设置员工名
				employee.setName(name);
				// 设置员工账号
				employee.setAccount(account);
				
				EmployeeManage employeeManage = new EmployeeManage();

				// 删除成功返回1 删除失败返回0
				Integer result = employeeManage.deleteEmployee(employee);

//				response.getWriter().println(result);
				System.out.println("删除的结果为:"+result);
	}}
