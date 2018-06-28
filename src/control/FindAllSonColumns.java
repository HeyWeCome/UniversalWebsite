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

import service.columns.ColumnsManage;

/** 
 * @ClassName:     FindAllSonColumns.java 
 * @Description:   找到所有的子栏目 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 下午4:48:03  
 */
public class FindAllSonColumns extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决前后格式不一致的问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 新建栏目Service对象
		ColumnsManage columnsManage = new ColumnsManage();

		String result = columnsManage.getAllSonColumns();

		if(!result.isEmpty()){
			JSONArray fromObject = (JSONArray) JSON.parse(result);
			System.out.println("sonColumns are:"+fromObject.toString());
			response.getWriter().print(fromObject);
		}else{
			response.getWriter().print(""); 
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
