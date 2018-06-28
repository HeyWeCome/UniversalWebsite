/**
 * 
 */
package entity;

/** 
 * @ClassName:     SonColumns.java 
 * @Description:   ����Ŀ�� 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����3:34:07  
 */
public class SonColumns {
	private Integer id;
	private String name;
	private String level;
	private Integer parentID;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public SonColumns() {
		super();
	}

	/**
	 * ���ι��췽��
	 * @param id
	 * @param name
	 * @param level
	 * @param parent
	 */
	public SonColumns(Integer id, String name, String level, Integer parentID) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.parentID = parentID;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	
}
