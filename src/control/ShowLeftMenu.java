/**
 *FileName:showLeftMenu.java
 * @author:lmy
 *Creatdate:2018骞�6鏈�28鏃ヤ笂鍗�10:14:38
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import service.module.ModuleManage;


/**
 * 
 * @ClassName:     ShowLeftMenu.java 
 * @Description:   展示左侧任务栏  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 下午2:53:13
 */
public class ShowLeftMenu extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 解决前后格式不一致的问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ModuleManage moduleManage = new ModuleManage();

		String result = moduleManage.findAllModule();

		JSONArray fromObject = (JSONArray) JSON.parse(result);
		System.out.println("找到的所有父类模板为:"+fromObject.toString());
		response.getWriter().print(fromObject);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
