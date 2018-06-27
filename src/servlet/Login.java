/**
 *FileName:login.java
 * @author:lmy
 *Creatdate:2018年6月26日下午10:59:33
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author lmy
 *
 */
public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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

		this.doPost(request,response);
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

		String account = request.getParameter("ACCOUNT");
		String password = request.getParameter("PASSWORD");
		
		if(account==null||account.isEmpty()){
            System.out.println("用户名不能为空");
            String a = URLEncoder.encode("用户名不能为空","UTF-8");
	   		PrintWriter out=response.getWriter();
	   		/*out.print("<script>alert(decodeURIComponent('"+a+"') );"
	   				+ "window.location.href='../login.jsp'</script>");*/
            //response.getWriter().print(-4);
	   		out.write("-1");
        }
    	if(password.isEmpty() || password==null){
    		 System.out.println("密码不能为空");
    		 String a = URLEncoder.encode("密码不能为空","UTF-8");
    		 PrintWriter out=response.getWriter();
    		 /*out.print("<script>alert(decodeURIComponent('"+a+"') );"
    				 + "window.location.href='../login.jsp'</script>");*/
    		 //response.getWriter().print(-3);
    		 out.write("-2");
    	}
    	if(!account.isEmpty()&&!account.equals("1234")){
    		System.out.println("用户名不存在");
    		//response.getWriter().print(-2);
    		String a = URLEncoder.encode("用户名不存在","UTF-8");
	   		PrintWriter out=response.getWriter();
	   		/*out.print("<script>alert(decodeURIComponent('"+a+"') );"
	   				+ "window.location.href='../login.jsp'</script>");*/
	   		out.write("-3");
    	}
    	if(!password.isEmpty()&&!password.equals("1234")){
    		System.out.println("密码输入错误");
    		String a = URLEncoder.encode("密码输入错误","UTF-8");
	   		PrintWriter out=response.getWriter();
	   		/*out.print("<script>alert(decodeURIComponent('"+a+"') );"
   		 		+ "window.location.href='../login.jsp'</script>");*/
    		//response.getWriter().print(-1);
	   		out.write("-4");
    	}
    	if(account.equals("1234")&&password.equals("1234")){
    		System.out.println("登录成功");
    		HttpSession httpsession = request.getSession();
    		httpsession.setAttribute("account", account);
    		PrintWriter out=response.getWriter();
    		//response.sendRedirect("../managerSelect.jsp?account="+account);
    		//response.getWriter().print(1);
    		out.write("1");
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
