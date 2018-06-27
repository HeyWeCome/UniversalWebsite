package entity;

/**
 * @ClassName:     Column.java 
 * @Description:   ��Ŀ��
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����9:46:38
 */
public class Columns {
	private String id;
	private String name;
	private String level;
	private String parentID;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Columns() {
		super();
	}

	/**
	 * ���ι��췽��
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
