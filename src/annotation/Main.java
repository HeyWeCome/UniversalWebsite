/**
 * 
 */
package annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Employee;
import service.account.AccountManage;
import service.module.ModuleManage;

/** 
 * @ClassName:     Main.java 
 * @Description:   用来测试的，记得删掉 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 上午10:22:23  
 */
public class Main {
	public static void main(String[] args){
//		Employee employee = new Employee();
//		employee.setAccount("superkang");
//		employee.setPassWord("123456");
//		
//		AccountManage accountManage = new AccountManage();
//		// 找到了就返回1，找不到就返回0
//		int result = accountManage.searchAccount(employee);
		
		ModuleManage moduleManage = new ModuleManage();

		String result = moduleManage.findAllSonModule();

		JSONArray fromObject = (JSONArray) JSON.parse(result);
		System.out.println("找到的所有子类模板为:"+fromObject.toString());
	}
}
