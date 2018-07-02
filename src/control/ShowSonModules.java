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

import service.module.ModuleManage;

/**
 * 
 * @ClassName:     ShowSonModules.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 上午10:58:04

 */
public class ShowSonModules extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ModuleManage moduleManage = new ModuleManage();

		String result = moduleManage.findAllSonModule();

		JSONArray fromObject = (JSONArray) JSON.parse(result);

		System.out.println("modules are:"+fromObject.toString());

		response.getWriter().print(fromObject);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
