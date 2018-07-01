/**
 * 
 */
package service.message;

import dao.SpecificDao;
import util.DBUtil;

/**
 * 留言类
 * @ClassName:     MessageManage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午4:29:42
 */
public class MessageManage implements IMessageManage{

	/**  
	 * @Title:        findAllMessage  
	 * @Description:  找到的所有的留言 
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午4:29:35  
	 */  
	public String findAllMessage() {
		String sql = SpecificDao.findAllMessage();
		System.out.println("要执行的sql为:"+sql);
		
		try {
			String result = DBUtil.findAllMessage(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
