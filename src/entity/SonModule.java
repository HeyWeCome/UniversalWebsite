package entity;

/**
 * 
 * @ClassName:     SonModule.java 
 * @Description:   子模块
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午10:02:26
 */
public class SonModule {
	private String id;
	private String name;
	private String status;
	
	/**
	 * 默认构造方法
	 */
	public SonModule() {
		super();
	}


	/**
	 * 含参构造方法
	 * @param id
	 * @param name
	 * @param status
	 */
	public SonModule(String id, String name, String status) {
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
