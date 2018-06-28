/**
 *FileName:ShowSonModules.java
 * @author:lmy
 *Creatdate:2018年6月28日下午1:04:47
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

import net.sf.json.JSONArray;
import dao.ModuleDao;
import entity.Module;

/**
 * @author lmy
 *
 */
public class ShowSonModules extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowSonModules() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sql = "select * from sonmodule";
		List<Module> resultList = new ArrayList<>();
		resultList = ModuleDao.getModuleDao().listSon();
		JSONArray jsonArray = net.sf.json.JSONArray.fromObject(resultList);
		
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");  
	    PrintWriter out = null;
	    try{
	    	out = response.getWriter();
	    	out.append(jsonArray.toString());
	    	System.out.println(jsonArray.toString());
	    }catch (IOException e) {  
	        e.printStackTrace();  
	    }finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
