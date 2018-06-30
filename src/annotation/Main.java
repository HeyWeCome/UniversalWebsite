/**
 * 
 */
package annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import dao.SpecificDao;
import entity.Article;
import entity.Employee;
import service.account.AccountManage;
import service.article.ArticleManage;
import service.columns.ColumnsManage;
import service.module.ModuleManage;
import service.role.RoleManage;
import util.DBUtil;

/**
 * 
 * @ClassName:     Main.java 
 * @Description:   测试类记得删除
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:56:50
 */
public class Main {
	public static void main(String[] args){
		// 生成文章管理service类
				ArticleManage articleManage = new ArticleManage();
				String result = articleManage.findAllAuditArticle();
				
				if(!result.isEmpty()){
					JSONArray fromObject = (JSONArray) JSON.parse(result);
					System.out.println("待审核的文章为:"+fromObject.toString());
//					response.getWriter().print(fromObject);
				}else{
//					response.getWriter().print(""); 
				}
	}
}
