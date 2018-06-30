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

import service.article.ArticleManage;

/** 
 * @ClassName:     FindAllAuditArticle.java 
 * @Description:   找到所有需要审核的文章
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午1:20:06  
 */
public class FindAllAuditArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决乱码
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 生成文章管理service类
		ArticleManage articleManage = new ArticleManage();
		String result = articleManage.findAllAuditArticle();
		
		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("待审核的文章为:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
