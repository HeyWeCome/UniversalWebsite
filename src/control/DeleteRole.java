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
import entity.Article;
import entity.Role;
import service.article.ArticleManage;
import service.role.RoleManage;
import util.DBUtil;

/** 
 * @ClassName:     DeleteRole.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午6:00:03  
 */
public class DeleteRole extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取文章名称
		String roleName = request.getParameter("roleName");	

		// 根据用户名查询用户ID
		String sql1 = SpecificDao.findIDFromTable(roleName, "employee");
		Integer roleID = 0;
		try {
			roleID = DBUtil.findID(sql1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 新建文章对象
		Role role = new Role();
		// 设置角色ID
		role.setId(roleID);
		// 设置角色名字
		role.setName(roleName);
		
		RoleManage roleManage = new RoleManage();

		// 删除成功返回1  删除失败返回0
		Integer result = roleManage.deleteRole(role);

		response.getWriter().println(result);
		System.out.println("删除的结果为:"+result);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
