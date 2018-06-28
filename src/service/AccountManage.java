package service;

import dao.SpecificDao;
import entity.Employee;
import util.DBUtil;

public class AccountManage implements IAccountManage{

	/**
	 * @Title:        searchAccount  
	 * @Description:  �������Ҹ��˺��Ƿ���������ݿ��� 
	 * @param:        @param emloyee
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����9:43:52
	 */
	@Override
	public Integer searchAccount(Employee employee) {
		// ��ȡ�˺�
		String account = employee.getAccount();
		// ��ȡ����
		String passWord = employee.getPassWord();
		
		String sql = SpecificDao.whetherAccountInTable(account, passWord, "employee");
		System.out.println("ִ�е�sql���Ϊ:"+sql);
		
		try {
			// �ҵ��˾ͷ���1���Ҳ����ͷ���0
			int result = DBUtil.findAccount(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����δ֪���󷵻�2
		return 2;
	}

}
