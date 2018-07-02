/**
 * 
 */
package service.module;

import entity.Module;
import entity.SonModule;

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
	Integer insertMoudle(Module Module);
	Integer insertSonMoudle(SonModule sonModule);
	String getAllPASModule();
	Integer updateModule(Module module);
}
