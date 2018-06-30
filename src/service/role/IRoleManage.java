/**
 * 
 */
package service.role;

import entity.Role;

/**
 * 
 * @ClassName:     IRoleManage.java 
 * @Description:   角色管理的接口 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:48:10
 */
public interface IRoleManage {
	String findAllRole();
	Integer deleteRole(Role role);
	Integer insertRole(Role role);
	Integer updateRole(Role role);
}
