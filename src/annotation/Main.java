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
import entity.Role;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
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
		// 获取角色名称
		String roleName ="何玮康";

		// 根据角色名查询角色ID
		String sql1 = SpecificDao.findIDFromTable(roleName, "role");
		Integer roleID = 0;
		try {
			roleID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建文章对象
		Role role = new Role();
		// 设置角色ID
		role.setId(roleID);
		// 设置角色名字
		role.setName(roleName);

		RoleManage roleManage = new RoleManage();

		// 删除成功返回1  删除失败返回0
		Integer result = roleManage.deleteRole(role);

//		response.getWriter().println(result);
		System.out.println("删除的结果为:"+result);
	}
}
