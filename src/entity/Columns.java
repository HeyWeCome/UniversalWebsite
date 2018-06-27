package entity;

/**
 * @ClassName:     Column.java 
 * @Description:   栏目表
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:46:38
 */
public class Columns {
	private String id;
	private String name;
	private String level;
	private String parentID;
	
	/**
	 * 默认构造方法
	 */
	public Columns() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param name
	 * @param level
	 * @param parent
	 */
	public Columns(String id, String name, String level, String parentID) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parentID = parentID;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParent(String parent) {
		this.parentID = parent;
	}
	
	
}
