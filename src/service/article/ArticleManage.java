/**
 * 
 */
package service.article;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Article;
import util.DBUtil;
import util.InSertDBUtil;

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

	/**  
	 * @Title:        InsertArticle  
	 * @Description:  插入文章
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午4:33:44  
	 */  
	@Override
	public Integer InsertArticle(Article article) {
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(article);
			System.out.println("要执行的sql为:"+sql);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		// 如果执行插入语句成功则返回：1    否则返回：0
		try {
			int result = InSertDBUtil.insertArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
