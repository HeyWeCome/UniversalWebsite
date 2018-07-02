/**
 * 
 */
package service.columns;

import dao.SpecificDao;
import util.DBUtil;

/**
 * 
 * @ClassName:     ColumnsManage.java 
 * @Description:   栏目管理 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午3:43:35
 */
public class ColumnsManage implements IColumnsManage{

	/**
	 * 
	 * @Title:        getAllColumns  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:41:09
	 */
	@Override
	public String getAllColumns() {
		// 生成sql
		String sql = SpecificDao.selectAllFromTable("columns");
		String result = "";

		System.out.println("要执行的sql为:"+sql);
		
		try {
			result = DBUtil.findAllColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @Title:        getAllSonColumns  
	 * @Description:  得到所有的子栏目 
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:41:33
	 */
	@Override
	public String getAllSonColumns() {
		
		String sql = SpecificDao.selectAllFromTable("soncolumns");
		String result = "";

		System.out.println("sql:"+sql);
		try {
			result = DBUtil.findAllSonColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**  
	 * @Title:        getAllPASColumns  
	 * @Description:  得到所有的父模块和子模块 
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:43:46  
	 */  
	@Override
	public String getAllPASColumns() {
		String sql = SpecificDao.findAllPASColumns();
		System.out.println("查询到的结果为:"+sql);
		
		String result = "";

		System.out.println("sql:"+sql);
		try {
			result = DBUtil.findAllPASColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
