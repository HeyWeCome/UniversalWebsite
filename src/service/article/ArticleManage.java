/**
 * 
 */
package service.article;

import dao.GeneralDao;
import dao.SpecificDao;
import entity.Article;
import util.DBUtil;
import util.DeleteDBUtil;
import util.InSertDBUtil;
import util.UpdateDBUtil;

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

	/**  
	 * @Title:        DeleteArticle  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午5:14:57  
	 */  
	@Override
	public Integer DeleteArticle(Article article) {
		// 获取标题
		String title = article.getTitle();
		// 获取作者账号
		Integer employeeID = article.getEmployeeID();

		String sql = SpecificDao.deleteArticle(employeeID,title);
		System.out.println("需要执行的sql为:"+sql);
		try {
			Integer result = DeleteDBUtil.deleteArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**  
	 * @Title:        findAllAuditArticle  
	 * @Description:  找到所有未审核通过的文章  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午1:25:16  
	 */  
	@Override
	public String findAllAuditArticle() {
		String sql = SpecificDao.selectAllAuditArticle();

		// 数据库操作后的结果
		String result = null;

		System.out.println("ִ要执行的sql为："+sql);

		try {
			result = DBUtil.findAllAuditArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**  
	 * @Title:        PassArticle  
	 * @Description:  更新文章状态  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午4:01:26  
	 */  
	@Override
	public Integer PassArticle(Article article) {
		// 获取文章名
		String title = article.getTitle();
		// 获取作者ID
		Integer employeeID = article.getEmployeeID();
		// 获取状态
		String status = article.getStatus();
		
		String sql = SpecificDao.passArticle(title, employeeID, status);
		System.out.println("需要执行的sql语句为:"+sql);
		
		
		try {
			Integer result = UpdateDBUtil.updateArticleStatus(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
