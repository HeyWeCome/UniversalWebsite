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
import entity.Role;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.employee.EmployeeManage;
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
		String title = "进化论";	
		// 获取作者
		String author = "何玮康";
		// 获取子栏目
		String columnName = "课程简介";
		// 获取是否置顶
		String whetherTop = "1";
		// 获取文章内容
		String content = "前排表达达尔文";

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

		// 根据栏目名查询栏目ID
		String sql2 = SpecificDao.findIDFromTable(columnName, "soncolumns");
		Integer sonColumnsID = 0;
		try {
			sonColumnsID = DBUtil.findID(sql2);
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
		// 设置子栏目ID
		article.setColumnID(sonColumnsID);
		// 设置文章内容
		article.setContent(content);
		// 设置文章是否置顶
				article.setWhetherTop(whetherTop);

		ArticleManage articleManage = new ArticleManage();

		Integer result = articleManage.updateArticle(article);
		System.out.println(result);
	}}
