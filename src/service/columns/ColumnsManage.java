/**
 * 
 */
package service.columns;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ColumnsManage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 下午4:33:11  
 */
public class ColumnsManage implements IColumnsManage{

	/**  
	 * @Title:        getAllColumns  
	 * @Description:  获取所有的栏目  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午4:33:59  
	 */  
	@Override
	public String getAllColumns() {
		// 获取到从columns表中读取所有内容的sql
		String sql = SpecificDao.selectAllFromTable("columns");
		String result = "";

		System.out.println("执行的sql语句为:"+sql);
		// 执行获取文章的操作
		try {
			result = DBUtil.findAllColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**  
	 * @Title:        getAllSonColumns  
	 * @Description:  找到所有的子栏目
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午4:51:53  
	 */  
	@Override
	public String getAllSonColumns() {
		// 获取到从columns表中读取所有内容的sql
		String sql = SpecificDao.selectAllFromTable("soncolumns");
		String result = "";

		System.out.println("sql:"+sql);
		// 执行获取文章的操作
		try {
			result = DBUtil.findAllSonColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
