package entity;

/**
 * 
 * @ClassName:     Module.java 
 * @Description:   ģ����  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����9:56:10
 */
public class Module {
	private String id;
	private String name;
	private String status;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Module() {
		super();
	}

	/**
	 * ���ι��췽��
	 * @param id
	 * @param name
	 * @param status
	 */
	public Module(String id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
