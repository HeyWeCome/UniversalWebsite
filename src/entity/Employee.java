package entity;

/**
 * @ClassName:     Employee.java 
 * @Description:   ��Ա��
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����9:50:44
 */
public class Employee {
	private String id;
	private String name;
	private String sex;
	private String account;
	private String passWord;
	private String roleID;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Employee() {
		super();
	}

	/**
	 * ���ι��췽��
	 * @param id
	 * @param name
	 * @param sex
	 * @param account
	 * @param passWord
	 * @param roleID
	 */
	public Employee(String id, String name, String sex, String account, String passWord, String roleID) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.account = account;
		this.passWord = passWord;
		this.roleID = roleID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
}
