/**
 * 
 */
package annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Article;
import entity.Employee;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
import service.role.RoleManage;

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
		
		Article newArticle = new Article();
		// 根据前台获取到的数据构建对象
		newArticle.setTitle("进化论2");
		newArticle.setEmployeeID(10000);
		newArticle.setColumnID(10000);
		newArticle.setContent("读进化论,我赞成达尔文！");
		newArticle.setWhetherTop("1");
		newArticle.setCreateTime(date);
		newArticle.setStatus("1");
		
		// 如果执行插入语句成功则返回：1    否则返回：0
		ArticleManage newArticleManage = new ArticleManage();
		Integer result = newArticleManage.InsertArticle(newArticle);
		
		System.out.println(result);
	}
}
