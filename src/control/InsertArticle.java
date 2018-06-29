/**
 * 
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecificDao;
import entity.Article;
import service.article.ArticleManage;
import util.DBUtil;

/** 
 * @ClassName:     InsertArticle.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午4:10:11  
 */
public class InsertArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 获取文章名称
		String title = request.getParameter("title");	
		// 获取作者
		String author = request.getParameter("author");
		// 获取栏目名称
		String columnName = request.getParameter("columnName");
		// 获取栏目内容
		String content = request.getParameter("content");
		// 获取是否置顶
		String whetherTop = request.getParameter("whetherTop");

		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// new Date()为获取当前系统时间，也可使用当前时间戳
		String date = df.format(new Date());
		
		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(author, "employee");
		Integer anthorID = null;
		try {
			anthorID = Integer.parseInt(DBUtil.findID(sql1));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 根据栏目名称查询栏目ID
		String sql2 = SpecificDao.findIDFromTable(columnName, "soncolumns");
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
		newArticle.setTitle(title);
		newArticle.setEmployeeID(anthorID);
		newArticle.setColumnID(columnID);
		newArticle.setContent(content);
		newArticle.setWhetherTop(whetherTop);
		newArticle.setCreateTime(date);
		newArticle.setStatus("1");
		
		// 如果执行插入语句成功则返回：1    否则返回：0
		ArticleManage newArticleManage = new ArticleManage();
		Integer result = newArticleManage.InsertArticle(newArticle);
		
		response.getWriter().println(result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
