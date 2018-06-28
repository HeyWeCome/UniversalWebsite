package entity;

/**
 * 
 * @ClassName:     Module.java 
 * @Description:   模块类  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:56:10
 */
public class Module {
	private Integer id;
	private String name;
	private String status;
	
	/**
	 * 默认构造方法
	 */
	public Module() {
		super();
	}

	/**
	 * 含参构造方法
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
