/**
 * 
 */
package entity;

/** 
 * @ClassName:     Course.java 
 * @Description:   课程 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午2:43:44  
 */
public class Course {
	Integer id;
	String name;
	String description;
	String principal;
	
	
	public Course() {
		super();
	}


	public Course(Integer id, String name, String description, String principal) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.principal = principal;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrincipal() {
		return principal;
	}


	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	
}
