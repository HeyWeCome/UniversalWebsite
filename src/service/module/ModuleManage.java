/**
 * 
 */
package service.module;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ModuleManage.java 
 * @Description:   模块管理类  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 上午11:02:42  
 */
public class ModuleManage implements IModuleManage{

	/**  
	 * @Title:        findAllModule  
	 * @Description:  返回所有的父类模块
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午2:39:17  
	 */  
	public String findAllModule() {
		String result = null;
		String sql = SpecificDao.selectAllFromTable("module");
		System.out.println("要执行的SQL为:"+sql);
		try {
			result = DBUtil.findAllModule(sql);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**  
	 * @Title:        findAllSonModule  
	 * @Description:  返回子模块 
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午3:06:30  
	 */  
	@Override
	public String findAllSonModule() {
		String result = null;
		String sql = SpecificDao.selectAllFromTable("sonmodule");
		System.out.println("要执行的SQL为:"+sql);
		try {
			result = DBUtil.findAllSonModule(sql);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
