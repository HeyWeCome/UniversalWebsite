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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import entity.Article;
import service.article.ArticleManage;

/** 
 * @ClassName:     HomePageFindAllSonColumnsArticleContent.java 
 * @Description:   查找文章内容 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午5:06:25  
 */
public class HomePageFindAllSonColumnsArticleContent extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String articleTitle = request.getParameter("articleTitle");
		Article article = new Article();
		article.setTitle(articleTitle);
		
		ArticleManage articleManage = new ArticleManage();
		String result = articleManage.findhomePageArticleContent(article);
		
		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("文章内容 are:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
