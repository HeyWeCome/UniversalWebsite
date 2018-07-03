/**
 * 
 */
package service.module;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Module;
import entity.SonModule;
import util.DBUtil;
import util.InSertDBUtil;
import util.UpdateDBUtil;

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
		String sql = SpecificDao.selectAllModule();
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
	public String findAllSonModule(String userName) {
		String result = null;
		String sql = SpecificDao.selectAccessSonColumns(userName);
		System.out.println("找到所有模块sql:"+sql);
		try {
			result = DBUtil.findAllSonModule(sql);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**  
	 * @Title:        insertSonMoudle  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:03:24  
	 */  
	@Override
	public Integer insertSonModule(SonModule sonModule) {
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(sonModule);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// 成功返回1   失败返回0
		try {
			Integer result = InSertDBUtil.insert(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**  
	 * @Title:        insertSonMoudle  
	 * @Description:  插入父模块  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:07:15  
	 */  
	@Override
	public Integer insertModule(Module Module) {
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(Module);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// 成功返回1   失败返回0
		try {
			Integer result = InSertDBUtil.insert(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**  
	 * @Title:        getAllPASColumns  
	 * @Description:  得到所有的父模块和子模块 
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:43:46  
	 */  
	@Override
	public String getAllPASModule() {
		String sql = SpecificDao.findAllPASModule();
		String result = "";

		System.out.println("sql:"+sql);
		try {
			result = DBUtil.findAllPASModule(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	/**  
	 * @Title:        updateModule  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:29:23  
	 */  
	@Override
	public Integer updateModule(Module module) {
		String sql = SpecificDao.updateModule(module);
		System.out.println("更新的sql为:"+sql);
		try {
			Integer result = UpdateDBUtil.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**  
	 * @Title:        updateSonMoudle  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @param:        @param sonModule
	 * @param:        @return     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:44:53  
	 */  
	public Integer updateSonMoudle(SonModule sonModule) {
		String sql = SpecificDao.updateSonModule(sonModule);
		System.out.println("更新的sql为:"+sql);
		try {
			Integer result = UpdateDBUtil.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
