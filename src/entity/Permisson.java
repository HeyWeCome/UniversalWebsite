package entity;

/**
 * 
 * @ClassName:     Permisson.java 
 * @Description:   权限类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:58:29
 */
public class Permisson {
	private String id;
	private String roleID;
	private String moduleID;
	
	/**
	 * 默认构造方法
	 */
	public Permisson() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param roleID
	 * @param moduleID
	 */
	public Permisson(String id, String roleID, String moduleID) {
		super();
		this.id = id;
		this.roleID = roleID;
		this.moduleID = moduleID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}
	
	
}
