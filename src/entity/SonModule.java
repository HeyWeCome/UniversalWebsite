package entity;

/**
 * 
 * @ClassName:     SonModule.java 
 * @Description:   ��ģ��
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����10:02:26
 */
public class SonModule {
<<<<<<< HEAD
	private int id;
=======
	private Integer id;
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
	private String name;
	private String status;
	private int parentModuleID;
	

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public SonModule() {
		super();
	}


	/**
	 * ���ι��췽��
	 * @param id
	 * @param name
	 * @param status
	 */
<<<<<<< HEAD
	public SonModule(int id, String name, String status) {
=======
	public SonModule(Integer id, String name, String status) {
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}


<<<<<<< HEAD
	public int getId() {
=======
	public Integer getId() {
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
		return id;
	}


<<<<<<< HEAD
	public void setId(int id) {
=======
	public void setId(Integer id) {
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
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
