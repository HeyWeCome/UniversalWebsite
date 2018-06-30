package entity;

/**
 * 
 * @ClassName:     Permisson.java 
 * @Description:   Ȩ���� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����9:58:29
 */
public class Permission {
	private Integer id;
	private Integer roleID;
	private Integer moduleID;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Permission() {
		super();
	}

	/**
	 * ���ι��췽��
	 * @param id
	 * @param roleID
	 * @param moduleID
	 */
	public Permission(Integer id, Integer roleID, Integer moduleID) {
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
