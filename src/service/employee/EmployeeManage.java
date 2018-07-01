/**
 * 
 */
package service.employee;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Employee;
import util.DBUtil;
import util.DeleteDBUtil;
import util.InSertDBUtil;

/** 
 * @ClassName:     EmployeeManage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午9:10:44  
 */
public class EmployeeManage implements IEmployeeManage{

	/**  
	 * @Title:        findAllEmployee  
	 * @Description:  找到所有的人员
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:11:01  
	 */  
	@Override
	public String findAllEmployee() {
		// 生成sql语句
		String sql = SpecificDao.findAllEmployee();
		// 存储查询到的结果
		String result = null;
		
		try {
			result = DBUtil.findAllEmployee(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**  
	 * @Title:        insertEmployee  
	 * @Description:  插入员工
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午12:36:39  
	 */  
	@Override
	public Integer insertEmployee(Employee employee) {
		// 生成sql语句
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(employee);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("要执行的sql为:"+sql);
		
		try {
			if(DBUtil.findEmployee(employee) == 1){
				return 0;
			}else{
				try {
					Integer result = InSertDBUtil.insertEmployee(sql);
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        deleteEmployee  
	 * @Description:  删除指定员工 
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午1:01:28  
	 */  
	@Override
	public Integer deleteEmployee(Employee employee) {
		String sql = SpecificDao.deleteEmployee(employee);
		System.out.println("执行的sql为"+sql);
		// 删除成功返回1   否则返回0
		try {
			Integer result = DeleteDBUtil.deleteEmployee(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
