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
	private Integer id;
	private Integer roleID;
	private Integer moduleID;
	
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
	public Permisson(Integer id, Integer roleID, Integer moduleID) {
		super();
		this.id = id;
		this.roleID = roleID;
		this.moduleID = moduleID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Integer getModuleID() {
		return moduleID;
	}

	public void setModuleID(Integer moduleID) {
		this.moduleID = moduleID;
	}
	
	
}
