package entity;

/**
 * @ClassName:     Module.java 
 * @Description:   ģ����
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��28�� ����2:27:28
 */
public class Module {

	private Integer id;
	private String name;
	private String status;
	
	/**
	 * 
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
	public Module(Integer id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
