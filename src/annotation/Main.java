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
 * @Description:   �������Եģ��ǵ�ɾ�� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����10:22:23  
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
		
		ModuleManage moduleManage = new ModuleManage();

		String result = moduleManage.findAllSonModule();

		JSONArray fromObject = (JSONArray) JSON.parse(result);
		System.out.println("�ҵ�����������ģ��Ϊ:"+fromObject.toString());
	}
}
