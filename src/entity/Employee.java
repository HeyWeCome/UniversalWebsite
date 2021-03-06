package entity;

/**
 * @ClassName:     Employee.java 
 * @Description:   人员类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:50:44
 */
public class Employee {
	private Integer id;
	private String name;
	private String sex;
	private String account;
	private String passWord;
	private Integer roleID;
	
	/**
	 * 默认构造方法
	 */
	public Employee() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param name
	 * @param sex
	 * @param account
	 * @param passWord
	 * @param roleID
	 */
	public Employee(Integer id, String name, String sex, String account, String passWord, Integer roleID) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.account = account;
		this.passWord = passWord;
		this.roleID = roleID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
}
