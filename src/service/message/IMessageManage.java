/**
 * 
 */
package service.message;

import entity.Message;

/**
 * 
 * @ClassName:     IMessageManage.java 
 * @Description:   更新信息接口类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月1日 下午8:22:52
 */
public interface IMessageManage {
	String findAllMessage();
	Integer updateMessage(Message message);
	Integer deleteMessage(Message message);
	String findAllHomePageMessage(Message message);
}
