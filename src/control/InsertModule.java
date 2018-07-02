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

import dao.SpecificDao;
import entity.Module;
import entity.SonModule;
import service.module.ModuleManage;
import util.DBUtil;

/** 
 * @ClassName:     InsertModule.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午10:50:49  
 */
public class InsertModule extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 控制格式,解决乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取模块名
		String name = request.getParameter("name");	
		// 获取父模块名
		String parentModuleName = request.getParameter("parentModuleName");
		if(parentModuleName.equals("已是父模块")){
			// 新建子模块对象
			Module Module = new Module();
			Module.setName(name);
			Module.setStatus("1");

			ModuleManage moduleManage = new ModuleManage();
			Integer result = moduleManage.insertMoudle(Module);
			response.getWriter().println(result);

		}else{
			// 根据用户名查询用户ID
			String sql1 = SpecificDao.findIDFromTable(parentModuleName, "module");
			System.out.println(sql1);
			Integer parentModuleID = 0;
			try {
				parentModuleID = DBUtil.findID(sql1);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 新建子模块对象
			SonModule sonModule = new SonModule();
			sonModule.setName(name);
			sonModule.setParentModuleID(parentModuleID);
			sonModule.setStatus("1");

			ModuleManage moduleManage = new ModuleManage();
			Integer result = moduleManage.insertSonMoudle(sonModule);
			response.getWriter().println(result);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
