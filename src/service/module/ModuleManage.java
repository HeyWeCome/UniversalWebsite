/**
 * 
 */
package service.module;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ModuleManage.java 
 * @Description:   ģ�������  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����11:02:42  
 */
public class ModuleManage implements IModuleManage{

	/**
	 * 
	 * @Title:        findAllModule  
	 * @Description:  找到所有父模块
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午4:25:59
	 */
	public String findAllModule() {
		String result = null;
		String sql = SpecificDao.selectAllFromTable("module");
		System.out.println("sql为:"+sql);
		try {
			result = DBUtil.findAllModule(sql);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @Title:        findAllSonModule  
	 * @Description:  找到所有子模块 
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午4:25:39
	 */
	@Override
	public String findAllSonModule() {
		String result = null;
		String sql = SpecificDao.selectAllFromTable("sonmodule");
		System.out.println("sql:"+sql);
		try {
			result = DBUtil.findAllSonModule(sql);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
