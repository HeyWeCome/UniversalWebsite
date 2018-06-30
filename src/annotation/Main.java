/**
 * 
 */
package annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import dao.SpecificDao;
import entity.Article;
import entity.Employee;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
import service.role.RoleManage;
import util.DBUtil;

/**
 * 
 * @ClassName:     Main.java 
 * @Description:   测试类记得删除
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:56:50
 */
public class Main {
	public static void main(String[] args){
		// 获取文章名称
				String title = "康哥回忆录";	
				// 获取作者
				String author = "何玮康";
				// 获取状态
				String status = "0";

				// 根据用户名查询用户ID
				String sql1 = SpecificDao.findIDFromTable(author, "employee");
				Integer anthorID = 0;
				try {
					anthorID = DBUtil.findID(sql1);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// 新建文章对象
				Article article = new Article();
				// 设置标题
				article.setTitle(title);
				// 设置作者账号
				article.setEmployeeID(anthorID);
				// 设置文章状态
				article.setStatus(status);

				ArticleManage articleManage = new ArticleManage();
				
				Integer result = articleManage.PassArticle(article);
				System.out.println(result);
//				response.getWriter().println(result);
	}
}
