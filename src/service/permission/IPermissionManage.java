/**
 * 
 */
package service.permission;
import entity.Permisson;
/** 
 * @ClassName:     IPermissionManage.java 
 * @Description:   增加权限接口
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月30日 下午10:41:32  
 */
public interface IPermissionManage {
	Integer insertPermission(Permisson permission);
}
