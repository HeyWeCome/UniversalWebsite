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
	 * @Title:        findAllModule  
	 * @Description:  �������еĸ���ģ��
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����2:39:17  
	 */  
	public String findAllModule() {
		String result = null;
		String sql = SpecificDao.selectAllFromTable("module");
		System.out.println("Ҫִ�е�SQLΪ:"+sql);
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
	 * @Description:  ������ģ�� 
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����3:06:30  
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
