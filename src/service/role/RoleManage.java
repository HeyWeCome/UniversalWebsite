/**
 * 
 */
package service.role;

import dao.SpecificDao;
import util.DBUtil;

/**
 * 
 * @ClassName:     RoleManage.java 
 * @Description:   角色管理
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:47:55
 */
public class RoleManage implements IRoleManage{

	/**  
	 * @Title:        findAllRole  
	 * @Description:  找到所有的角色
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:48:37  
	 */  
	@Override
	public String findAllRole() {
		String sql = SpecificDao.selectAllFromTable("role");
		// 要返回的数据
		String result = null;
		// 打印sql语句
		System.out.println("要执行的sql语句为:"+sql);
		
		try {
			result = DBUtil.findAllRoles(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
