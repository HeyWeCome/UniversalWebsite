/**
 * 
 */
package service.permission;

import dao.GeneralDao;
import entity.Permission;
import util.InSertDBUtil;

/** 
 * @ClassName:     PermissionManage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午10:46:55  
 */
public class PermissionManage implements IPermissionManage{

	/**  
	 * @Title:        insertPermission  
	 * @Description:  插入权限 
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午10:47:13  
	 */  
	@Override
	public Integer insertPermission(Permission permission) {
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(permission);
			System.out.println("执行的sql为:"+sql);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		try {
			// 操作成功返回1 失败 0
			Integer result = InSertDBUtil.insertPermission(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
