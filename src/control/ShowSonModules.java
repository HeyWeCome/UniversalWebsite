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
 * @ClassName:     ShowSonModules.java 
 * @Description:   չʾ���е�����ģ�� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����3:03:40  
 */
public class ShowSonModules extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ���ǰ���ʽ��һ�µ�����
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ModuleManage moduleManage = new ModuleManage();

		String result = moduleManage.findAllSonModule();

		JSONArray fromObject = (JSONArray) JSON.parse(result);
		System.out.println("找到的所有子模块为:"+fromObject.toString());
		response.getWriter().print(fromObject);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
