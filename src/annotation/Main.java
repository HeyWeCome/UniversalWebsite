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

		// 获取员工的ID
		String roleID = "1";	

		// 新增角色对象
		Permission permission = new Permission();
		permission.setRoleID(Integer.parseInt(roleID));

		PermissionManage permissionManage = new PermissionManage();
		String result = permissionManage.findAllOwnPermission(permission);
		
		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("已有权限为:"+fromObject.toString());
//			response.getWriter().print(fromObject);
		}else{
//			response.getWriter().print(""); 
		}
	}}
