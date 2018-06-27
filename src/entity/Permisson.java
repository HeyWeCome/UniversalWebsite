package entity;

/**
 * 
 * @ClassName:     Permisson.java 
 * @Description:   Ȩ���� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����9:58:29
 */
public class Permisson {
	private String id;
	private String roleID;
	private String moduleID;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Permisson() {
		super();
	}

	/**
	 * ���ι��췽��
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
