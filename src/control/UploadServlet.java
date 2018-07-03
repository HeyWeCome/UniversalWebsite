/**
 * 
 */
package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.SpecificDao;
import entity.SourceFile;
import service.sourcefile.SourceFileManage;
import util.DBUtil;

/** 
 * @ClassName:     UploadServlet.java 
 * @Description:   上传文件使用的servlet  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 上午10:07:47  
 */

public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String title = null;
		String author = null;
		
		//文件存储路径
		String path="C:/upload";
		//临时文件存储路径
		String tempPath="C:/upload";
		File file=new File(path);
		File temp=new File(tempPath);
		//如果目录不存在就创建
		if(!file.exists() && !file.isDirectory()){
			file.mkdirs();
		}
		//如果目录不存在就创建
		if(!temp.exists() && !temp.isDirectory()){
			file.mkdirs();
		}

		//检查输入是否是Multipart表单数据
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//设置缓存区大小，当上传文件超过缓存区大小时候就会存储到临时文件中,缓存区默认大小事10kb
			factory.setSizeThreshold(1024*100);//设置缓存区为100kb
			//设置临时文件保存目录
			factory.setRepository(temp);
			ServletFileUpload upload=new ServletFileUpload(factory);
			//如果上传文件是中文，解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			//监听上传文件进度
			upload.setProgressListener(new ProgressListener (){
				@Override
				public void update(long arg0, long arg1, int arg2) {
					//					System.out.println("当前已经上传"+arg0);
					//					System.out.println("总大小"+arg1);
				}
			});
			//设置上传一个文件的最大容量
			upload.setFileSizeMax(1024*1000);
			//设置上传文件的总容量
			upload.setSizeMax(1024*1000*10);
			List<FileItem> list=null;
			try {
				list=upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			//每个item对应表单的一行,遍历表单的每一行
			for(FileItem item:list){
				//检查当前项目是普通表单项目还是上传文件。
				if(item.isFormField()){
					
					//表单name值
					String name=item.getFieldName();
					if(name.equals("title")){
						//表单value值
						title = item.getString("UTF-8");
					}else if(name.equals("author")){
						author = item.getString("UTF-8");
					}			

				}else{
					System.out.println("title:"+title);
					System.out.println("author:"+author);
					
					// 根据用户名查询用户ID
					String sql1 = SpecificDao.findIDFromTable(author, "employee");
					System.out.println(sql1);
					Integer authorID = 0;
					try {
						authorID = DBUtil.findID(sql1);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					// 查询文章的ID
					String sql2 = SpecificDao.findArticleID(title, authorID);
					System.out.println(sql1);
					Integer articleID = 0;
					try {
						articleID = DBUtil.findID(sql2);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("文章ID为:"+articleID);
					
					
					//上传文件的文件名称
					String fileName=item.getName();
					System.out.println(fileName);
					//去掉文件路径，取得文件名
					fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
					//获取文件的扩展名
					String fileExt=fileName.substring(fileName.lastIndexOf(".")+1);
					//					System.out.println(fileExt);
					//生成唯一的文件名和ID
					String ranID = UUID.randomUUID().toString();
					String trueName=ranID+fileName;

					InputStream is=item.getInputStream();
					System.out.println(path+File.separator+fileName);
					System.out.println("真实路径:"+path+File.separator+trueName);
					OutputStream os=new FileOutputStream(path+File.separator+trueName);
					byte[] flush=new byte[1024];
					int len=0;
					while( (len=is.read())!=-1 ){
						os.write(len);
					}

					// 新建一个资源文件类
					SourceFile sourceFile = new SourceFile();
					sourceFile.setArticleID(articleID);
					sourceFile.setName(fileName);
					
					sourceFile.setPath((path+File.separator+File.separator+trueName).replaceAll("\\\\", "/").replaceAll("//", "/"));
					System.out.println("文件的路径"+sourceFile.getPath());
					SourceFileManage newSourceFileManage = new SourceFileManage();
					
					Integer result = newSourceFileManage.saveResource(sourceFile);
					System.out.println("操作结果为:"+result);
					System.out.println();
					os.flush();
					os.close();
					is.close();
					item.delete();

				}
			}

		}else{
			System.out.println("没有设置multipart/form-data");
		}
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	 /**
     * 从http头部解析文件名字
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}
