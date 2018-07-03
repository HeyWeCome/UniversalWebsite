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

import entity.SonColumns;
import service.columns.ColumnsManage;

/** 
 * @ClassName:     HomePageFindAllSonColumnsArticle.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午4:50:46  
 */
public class HomePageFindAllSonColumnsArticle extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 获取到课程传递过来的子栏目的ID
		Integer courseSonColumnsId = Integer.parseInt(request.getParameter("courseSonColumnsId"));
		System.out.println("子栏目ID"+courseSonColumnsId);
		SonColumns soncolumns = new SonColumns();
		soncolumns.setId(courseSonColumnsId);
		
		ColumnsManage manage = new ColumnsManage();
		String result = manage.findAllArticle(soncolumns);
		
		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("文章名 are:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
