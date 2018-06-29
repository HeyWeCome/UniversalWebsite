package service.account;

import dao.SpecificDao;
import entity.Employee;
import util.DBUtil;

public class AccountManage implements IAccountManage{

	/**
	 * 
	 * @Title:        searchAccount  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午9:09:20
	 */
	@Override
	public Integer searchAccount(Employee employee) {

		String account = employee.getAccount();

		String passWord = employee.getPassWord();
		
		String sql = SpecificDao.whetherAccountInTable(account, passWord, "employee");
		System.out.println("ִ�е�sql���Ϊ:"+sql);
		
		try {

			int result = DBUtil.findAccount(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 2;
	}

	/**  
	 * @Title:        searchUserName  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午9:03:43  
	 */  
	@Override
	public String searchUserName(Employee emloyee) {
		String account = emloyee.getAccount();

		String passWord = emloyee.getPassWord();
		
		String sql = SpecificDao.findUserName(account, passWord);
		System.out.println("ִ要执行的sql为:"+sql);
		
		try {
			
			String result = DBUtil.findUserName(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
