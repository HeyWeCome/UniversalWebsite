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
 * @ClassName:     FindArticleContent.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午9:41:16  
 */
public class FindArticleContent extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取文章名称
		String title = request.getParameter("title");	
		// 获取作者
		String author = request.getParameter("author");
		// 返回到前台的文章内容
		String result = null;

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

		// 新建文章service对象
		ArticleManage articleManage = new ArticleManage();
		result = articleManage.findArticleContent(article);
		
		response.getWriter().print("[\""+result+"\"]");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
