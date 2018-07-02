/**
 * 
 */
package service.module;

/**
 * 
 * @ClassName:     IModuleManage.java 
 * @Description:   模块管理接口类  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午4:43:37
 */
public interface IModuleManage {
	String findAllModule();
	String findAllSonModule(String userName);
}
