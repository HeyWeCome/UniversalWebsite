package service;

import dao.SpecificDao;
import entity.Employee;
import util.DBUtil;

public class AccountManage implements IAccountManage{

	/**
	 * @Title:        searchAccount  
	 * @Description:  用来查找该账号是否存在于数据库中 
	 * @param:        @param emloyee
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 上午9:43:52
	 */
	@Override
	public Integer searchAccount(Employee employee) {
		// 获取账号
		String account = employee.getAccount();
		// 获取密码
		String passWord = employee.getPassWord();
		
		String sql = SpecificDao.whetherAccountInTable(account, passWord, "employee");
		System.out.println("执行的sql语句为:"+sql);
		
		try {
			// 找到了就返回1，找不到就返回0
			int result = DBUtil.findAccount(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 发生未知错误返回2
		return 2;
	}

}
