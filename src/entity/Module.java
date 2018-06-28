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
<<<<<<< HEAD
	private int id;
=======
	private Integer id;
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
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
<<<<<<< HEAD
	public Module(int id, String name, String status) {
=======
	public Module(Integer id, String name, String status) {
>>>>>>> 8efdd84d29a146ede1c63c30b48628e054a1c099
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

<<<<<<< HEAD
	public int getId() {
		return id;
	}

	public void setId(int id) {
=======
	public Integer getId() {
		return id;
	}

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
	
	
}
