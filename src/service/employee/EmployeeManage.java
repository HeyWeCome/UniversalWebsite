/**
 * 
 */
package service.employee;

import dao.SpecificDao;
import util.DBUtil;

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

}
