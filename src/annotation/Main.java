/**
 * 
 */
package annotation;

import entity.Employee;
import service.AccountManage;

/** 
 * @ClassName:     Main.java 
 * @Description:   �������Եģ��ǵ�ɾ�� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����10:22:23  
 */
public class Main {
	public static void main(String[] args){
		Employee employee = new Employee();
		employee.setAccount("superkang");
		employee.setPassWord("123456");
		
		AccountManage accountManage = new AccountManage();
		// �ҵ��˾ͷ���1���Ҳ����ͷ���0
		int result = accountManage.searchAccount(employee);
		System.out.println("��Ϊ:"+result);
	}
}
