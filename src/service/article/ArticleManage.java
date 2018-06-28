/**
 * 
 */
package service.article;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ArticleManage.java 
 * @Description:   ���·���ʵ���� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����11:11:21  
 */
public class ArticleManage implements IArticleManage{

	/**  
	 * @Title:        findAllArticle  
	 * @Description:  �ҵ���������
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����3:38:43  
	 */  
	@Override
	public String findAllArticle() {
		// ���ɴ����±������е�����
		String sql = SpecificDao.selectAllFromTable("article");
		// �����洢�����ݿ���в�ѯ���Ľ��
		String result = null;
		
		System.out.println("ִ�е�sql���Ϊ:"+sql);
		// ִ�л�ȡ���µĲ���
		try {
			result = DBUtil.findAllArticle(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
