package dao;

/**
 * 
 * @ClassName:     SpecificDao.java 
 * @Description:   对数据库操作的特殊类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午10:31:59
 */
public class SpecificDao {
	/**
	 * @Title:        whetherAccountInTable  
	 * @Description:  用来查找指定表中是否存在指定账号 
	 * @param:        @param id
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 上午9:52:32
	 */
	public static String whetherAccountInTable(String account, String passWord, String tableName){
		return "select * from "+tableName+" where account = '"+account+"' and passWord = '"+passWord+"';";
	}
	
	/**
	 * @Title:        selectAllFromTable  
	 * @Description:  找出指定表中所有的元素
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月28日 下午2:35:09
	 */
	public static String selectAllFromTable(String tableName){
		return "select * from "+tableName+";";
	}
}
