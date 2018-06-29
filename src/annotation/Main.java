/**
 * 
 */
package annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Employee;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
import service.role.RoleManage;

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
		//		Employee employee = new Employee();
		//		employee.setAccount("superkang");
		//		employee.setPassWord("123456");
		//		
		//		AccountManage accountManage = new AccountManage();
		//		// �ҵ��˾ͷ���1���Ҳ����ͷ���0
		//		int result = accountManage.searchAccount(employee);

		// 生成角色管理service类
		RoleManage roleManage = new RoleManage();

		String result = roleManage.findAllRole();

		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("roles are:"+fromObject.toString());
//			response.getWriter().print(fromObject);
		}else{
//			response.getWriter().print(""); 
		}
	}
}
