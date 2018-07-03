/**
 * 
 */
package service.columns;

import dao.SpecificDao;
import entity.Columns;
import entity.SonColumns;
import util.DBUtil;
import util.UpdateDBUtil;

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
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:49:26  
	 */  
	@Override
	public String getAllPASColumns() {
		String sql = SpecificDao.findAllPASColumns();
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

	/**  
	 * @Title:        updateColumns  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午12:22:07  
	 */  
	@Override
	public Integer updateColumns(Columns columns) {
		String sql = SpecificDao.updateColumns(columns);

		try {
			Integer result = UpdateDBUtil.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        updateSonColumns  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午12:22:07  
	 */  
	@Override
	public Integer updateSonColumns(SonColumns sonColumns) {
		String sql = SpecificDao.updateSonColumns(sonColumns);

		try {
			Integer result = UpdateDBUtil.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



}
