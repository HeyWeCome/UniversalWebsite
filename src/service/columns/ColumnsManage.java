/**
 * 
 */
package service.columns;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Columns;
import entity.SonColumns;
import util.DBUtil;
import util.DeleteDBUtil;
import util.InSertDBUtil;
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

	/**  
	 * @Title:        insertColumn  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午10:19:45  
	 */  
	@Override
	public Integer insertColumn(Columns columns) {
		String sql;
		try {
			sql = GeneralDao.generalInsertSQL(columns);
			try {
				Integer result = InSertDBUtil.insert(sql);
				return result;
			} catch (Exception e) {

				e.printStackTrace();
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        insertSonColumns  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午10:19:45  
	 */  
	@Override
	public Integer insertSonColumns(SonColumns sonColumns) {
		String sql;
		try {
			sql = GeneralDao.generalInsertSQL(sonColumns);
			try {
				Integer result = InSertDBUtil.insert(sql);
				return result;
			} catch (Exception e) {

				e.printStackTrace();
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        deleteColumns  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午10:37:44  
	 */  
	@Override
	public Integer deleteColumns(Columns columns) {
		String sql = SpecificDao.deleteColumns(columns);
		System.out.println("要执行的sql："+sql);
		try {
			Integer result = DeleteDBUtil.delete(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

	/**
	 * 
	 * @Title:        deleteSonColumns  
	 * @Description:  删除子栏目
	 * @param:        @param soncolumns
	 * @param:        @return     
	 * @return:       Integer     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午10:41:16
	 */
	@Override
	public Integer deleteSonColumns(SonColumns soncolumns) {
		String sql = SpecificDao.deleteSonColumns(soncolumns);
		System.out.println("要执行的sql："+sql);
		try {
			Integer result = DeleteDBUtil.delete(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        findAllArticle  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午4:54:49  
	 */  
	@Override
	public String findAllArticle(SonColumns soncolumns) {
		String sql = "select article.title "
				+ " from article,soncolumns "
				+ "where soncolumns.id = article.columnID "
				+ "and soncolumns.id = "+soncolumns.getId()+""
						+ " and article.status = '1';";
		
		System.out.println("sql:"+sql);
		try {
			String result = DBUtil.findhomePageAllArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
