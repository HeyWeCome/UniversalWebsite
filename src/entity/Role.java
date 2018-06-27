package entity;

/**
 * 
 * @ClassName:     Role.java 
 * @Description:   角色类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午10:01:03
 */
public class Role {
	private String id;
	private String name;
	private String createTime;
	private String description;
	
	/**
	 * 默认构造方法
	 */
	public Role() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param name
	 * @param createTime
	 * @param permissionID
	 * @param description
	 */
	public Role(String id, String name, String createTime, String description) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.description = description;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
