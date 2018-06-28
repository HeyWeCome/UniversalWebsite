/**
 * 
 */
package service.columns;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     ColumnsManage.java 
 * @Description:   TODO(��һ�仰�������ļ���ʲô)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����4:33:11  
 */
public class ColumnsManage implements IColumnsManage{

	/**  
	 * @Title:        getAllColumns  
	 * @Description:  ��ȡ���е���Ŀ  
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����4:33:59  
	 */  
	@Override
	public String getAllColumns() {
		// ��ȡ����columns���ж�ȡ�������ݵ�sql
		String sql = SpecificDao.selectAllFromTable("columns");
		String result = "";

		System.out.println("ִ�е�sql���Ϊ:"+sql);
		// ִ�л�ȡ���µĲ���
		try {
			result = DBUtil.findAllColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**  
	 * @Title:        getAllSonColumns  
	 * @Description:  �ҵ����е�����Ŀ
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����4:51:53  
	 */  
	@Override
	public String getAllSonColumns() {
		// ��ȡ����columns���ж�ȡ�������ݵ�sql
		String sql = SpecificDao.selectAllFromTable("soncolumns");
		String result = "";

		System.out.println("sql:"+sql);
		// ִ�л�ȡ���µĲ���
		try {
			result = DBUtil.findAllSonColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
