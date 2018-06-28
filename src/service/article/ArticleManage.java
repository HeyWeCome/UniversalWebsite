/**
 * 
 */
package service.article;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ArticleManage.java 
 * @Description:   文章方法实现类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 上午11:11:21  
 */
public class ArticleManage implements IArticleManage{

	/**  
	 * @Title:        findAllArticle  
	 * @Description:  找到所有文章
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午3:38:43  
	 */  
	@Override
	public String findAllArticle() {
		// 生成从文章表中所有的内容
		String sql = SpecificDao.selectAllFromTable("article");
		// 用来存储从数据库表中查询到的结果
		String result = null;
		
		System.out.println("执行的sql语句为:"+sql);
		// 执行获取文章的操作
		try {
			result = DBUtil.findAllArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
