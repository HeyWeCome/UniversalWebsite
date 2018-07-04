/**
 * 
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     SourceFileDownload.java 
 * @Description:   文件下载  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午3:26:15  
 */
public class SourceFileDownload extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决前后乱码问题
		response.setContentType("text/json");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 获取到文件名
		String name = request.getParameter("name");
		System.out.println("name为"+name);
		
		// 根据课程名查询课程ID
		String sql1 = SpecificDao.findFilePath(name);
		System.out.println("要执行的sql为:"+sql1);
		String path = null;
		try {
			path = DBUtil.findFilePath(sql1);
			path = path.replaceAll("\\\\", "/");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//处理请求  
		//读取要下载的文件  
		File file = new File(path);  

		// 从路径读取文件
		String filePath = file.getPath();
		System.out.println("filePath为:"+filePath);
		java.io.File downloadFile = new java.io.File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);

		// 使用相对路径
		String relativePath = getServletContext().getRealPath("");

		// 获取context对象
		ServletContext context = getServletContext();

		// 获取文件类型
		String mimeType = context.getMimeType(filePath);
		if (mimeType == null) {
			// 设为二进制
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// 修改response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// 强迫下载
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// 获取 response 中的 输出流
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();
		
//		response.getWriter().println(1);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
