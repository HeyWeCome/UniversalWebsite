package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Title: Login</p>
 * <p>Description: ����Ա������û���¼��̨</p>
 * @author Vico.Ho
 * @date ����9:23:42
 */
public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ǰ���ʽ��һ�µ�����
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//ǰ��������˺�
		String user = request.getParameter("account");	
		//ǰ�����������
		String passW = request.getParameter("passWord");		
		
		// ������¼�����ݿ���
		String passWord = null;
		
		
	}

	/**
	 * ����get����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
