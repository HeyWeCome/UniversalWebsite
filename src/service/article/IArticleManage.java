/**
 * 
 */
package service.article;

import entity.Article;

/**
 * 
 * @ClassName:     IArticleManage.java 
 * @Description:   文章管理接口 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午4:32:49
 */
public interface IArticleManage {
	String findAllArticle();
	Integer InsertArticle(Article article);
	Integer DeleteArticle(Article article);
	String findAllAuditArticle();
	Integer PassArticle(Article article);
}
