package entity;

/**
 * 
 * @ClassName:     SonModule.java 
 * @Description:   子模块类  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月28日 下午2:28:45
 */
public class SonModule {

	private Integer id;
	private String name;
	private String status;
	private int parentModuleID;
	

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

	public SonModule(Integer id, String name, String status) {

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
	
	public int getParentModuleID() {
		return parentModuleID;
	}


	public void setParentModuleID(int parentModuleID) {
		this.parentModuleID = parentModuleID;
	}
}
