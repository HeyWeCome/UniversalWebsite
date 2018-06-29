/**
 * 
 */
package service.article;

import dao.SpecificDao;
import util.DBUtil;

/**
 * 
 * @ClassName:     ArticleManage.java 
 * @Description:   文章资源管理  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:45:41
 */
public class ArticleManage implements IArticleManage{

	/**
	 * 
	 * @Title:        findAllArticle  
	 * @Description:  找到所有文章  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:45:58
	 */
	@Override
	public String findAllArticle() {
		// 得到需要执行的sql
		String sql = SpecificDao.selectAllArticle();
		// 数据库操作后的结果
		String result = null;
		
		System.out.println("ִ要执行的sql为："+sql);
		
		try {
			result = DBUtil.findAllArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
