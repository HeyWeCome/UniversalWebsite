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
import entity.Message;
import entity.Module;
import entity.Permission;
import entity.Role;
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
				String name = "系统设置";	
				// 获取状态
				String status = "0";

				// 获取父模块名
				String parentModuleName = "已是父模块";
				if(parentModuleName.equals("已是父模块")){
					// 新建父模块对象
					Module Module = new Module();
					Module.setName(name);
					Module.setStatus(status);

					ModuleManage moduleManage = new ModuleManage();
					Integer result = moduleManage.updateModule(Module);
//					response.getWriter().println(result);

				}else{
					// 根据用户名查询用户ID
					String sql1 = SpecificDao.findIDFromTable(parentModuleName, "module");
					System.out.println(sql1);
					Integer parentModuleID = 0;
					try {
						parentModuleID = DBUtil.findID(sql1);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

					// 新建子模块对象
					SonModule sonModule = new SonModule();
					sonModule.setName(name);
					sonModule.setParentModuleID(parentModuleID);
					sonModule.setStatus(status);

					ModuleManage moduleManage = new ModuleManage();
					Integer result = moduleManage.updateSonMoudle(sonModule);
					
//					response.getWriter().println(result);
				}
	}
}
