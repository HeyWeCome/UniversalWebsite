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
 * @ClassName:     UpdateAuditArticle.java 
 * @Description:   审核文章状态
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午2:43:13  
 */
public class UpdateAuditArticle extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("进入UpdateAuditArticle");
		// 获取文章名称
		String title = request.getParameter("title");	
		// 获取作者
		String author = request.getParameter("author");
		// 获取状态
		String status = request.getParameter("status");
		System.out.println("传回的数据："+title+" "+author+" "+status);
		
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
		
		response.getWriter().println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);

	}

}
