/**
 * 
 */
package service.role;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Role;
import util.DBUtil;
import util.DeleteDBUtil;
import util.InSertDBUtil;
import util.UpdateDBUtil;

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

	/**  
	 * @Title:        deleteRole  
	 * @Description:  删除角色
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午6:06:28  
	 */  
	@Override
	public Integer deleteRole(Role role) {
		// 获取ID
		Integer roleID = role.getId();

		String sql = SpecificDao.deletRole(roleID);
		
		System.out.println("需要执行的sql为:"+sql);
		try {
			Integer result = DeleteDBUtil.deleteRole(sql);
			// 成功返回1 否则返回0
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**  
	 * @Title:        insertRole  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午11:09:50  
	 */  
	@Override
	public Integer insertRole(Role role) {
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(role);
			System.out.println("执行的sql为:"+sql);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Integer result = InSertDBUtil.insertRole(sql);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        updateRole  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午11:19:13  
	 */  
	@Override
	public Integer updateRole(Role role) {
		String sql = null;
		sql = SpecificDao.updateRole(role);

		System.out.println("需要执行的sql为"+sql);
		
		try {
			Integer result = UpdateDBUtil.updateRole(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
