/**
 * 
 */
package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import service.article.ArticleManage;

/**
 * 
 * @ClassName:     FindAllArticle.java 
 * @Description:   找到所有文章
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 上午10:55:01
 */
public class FindAllArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 生成文章管理service类
		ArticleManage articleManage = new ArticleManage();
		
		String result = articleManage.findAllArticle();

		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("articles are:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
