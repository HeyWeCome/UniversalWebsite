package dao;

/**
 * 
 * @ClassName:     SpecificDao.java 
 * @Description:   �����ݿ������������
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����10:31:59
 */
public class SpecificDao {
	/**
	 * @Title:        whetherAccountInTable  
	 * @Description:  ��������ָ�������Ƿ����ָ���˺� 
	 * @param:        @param id
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����9:52:32
	 */
	public static String whetherAccountInTable(String account, String passWord, String tableName){
		return "select * from "+tableName+" where account = '"+account+"' and passWord = '"+passWord+"';";
	}
	
	/**
	 * @Title:        selectAllFromTable  
	 * @Description:  �ҳ�ָ���������е�Ԫ��
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018��6��28�� ����2:35:09
	 */
	public static String selectAllFromTable(String tableName){
		return "select * from "+tableName+";";
	}
}
