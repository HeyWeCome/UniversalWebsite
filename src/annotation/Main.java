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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable("何玮康", "employee");
		System.out.println(sql1);
		Integer anthorID = null;
		try {
			anthorID = Integer.parseInt(DBUtil.findID(sql1));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 根据栏目名称查询栏目ID
		String sql2 = SpecificDao.findIDFromTable("教学方法", "soncolumns");
		System.out.println(sql2);
		Integer columnID = null;
		try {
			columnID = Integer.parseInt(DBUtil.findID(sql1));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Article newArticle = new Article();
		// 根据前台获取到的数据构建对象
		newArticle.setTitle("资治通鉴");
		newArticle.setEmployeeID(anthorID);
		newArticle.setColumnID(columnID);
		newArticle.setContent("司马光回忆录");
		newArticle.setWhetherTop("1");
		newArticle.setCreateTime(date);
		newArticle.setStatus("1");

		// 如果执行插入语句成功则返回：1    否则返回：0
		ArticleManage newArticleManage = new ArticleManage();
		Integer result = newArticleManage.InsertArticle(newArticle);


		System.out.println(result);
	}
}
