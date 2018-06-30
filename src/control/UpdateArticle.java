/**
 * 
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecificDao;
import entity.Article;
import service.article.ArticleManage;
import util.DBUtil;

/** 
 * @ClassName:     UpdateArticle.java 
 * @Description:   更新文章 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午9:32:04  
 */
public class UpdateArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取文章名称
		String title = request.getParameter("title");	
		// 获取作者
		String author = request.getParameter("author");
		// 获取子栏目
		String columnName = request.getParameter("columnName");
		// 获取是否置顶
		String whetherTop = request.getParameter("whetherTop");
		// 获取文章内容
		String content = request.getParameter("content");

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
		response.getWriter().println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
