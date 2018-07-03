/**
 * 
 */
package service.message;

import dao.SpecificDao;
import entity.Message;
import util.DBUtil;
import util.DeleteDBUtil;
import util.UpdateDBUtil;

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

	/**  
	 * @Title:        updateMessage  
	 * @Description:  更新留言表  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午8:23:34  
	 */  
	@Override
	public Integer updateMessage(Message message) {
		String sql = SpecificDao.updateMessage(message);
		
		try {
			Integer result = UpdateDBUtil.update(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        deleteMessage  
	 * @Description:  删除留言
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 上午9:37:49  
	 */  
	@Override
	public Integer deleteMessage(Message message) {
		String sql = SpecificDao.deleteMessage(message);
		System.out.println("需要执行的sql为："+sql);
		
		// 删除成功返回1  否则返回0
		try {
			Integer result = DeleteDBUtil.delete(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**  
	 * @Title:        findAllHomePageMessage  
	 * @Description:  TODO(这里用一句话描述这个方法的作用)  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午5:24:50  
	 */  
	@Override
	public String findAllHomePageMessage(Message message) {
		String sql = "select id,content,createTime,reply,employeeID,replyTime,status,courseID "
				   + " from message "
				   + " where message.courseID = "+message.getCourseID()+";";
		
		System.out.println("要执行的sql为:"+sql);
		
		try {
			String result = DBUtil.findAllHomePageMessage(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
