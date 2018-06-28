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
 * @ClassName:     FindAllArticle.java 
 * @Description:   TODO(��һ�仰�������ļ���ʲô)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����3:32:06  
 */
public class FindAllArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ǰ���ʽ��һ�µ�����
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// �½�����Service����
		ArticleManage articleManage = new ArticleManage();
		
		String result = articleManage.findAllArticle();

		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("�ҵ�������Ϊ:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
