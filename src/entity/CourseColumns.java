/**
 * 
 */
package entity;

/** 
 * @ClassName:     CourseColumns.java 
 * @Description:   课程栏目对应表
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午2:45:28  
 */
public class CourseColumns {
	Integer id;		
	Integer courseID;
	Integer columnsID;

	public CourseColumns(Integer id, Integer courseID, Integer columnsID) {
		super();
		this.id = id;
		this.courseID = courseID;
		this.columnsID = columnsID;
	}
	
	/**
	 * 
	 */
	public CourseColumns() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCourseID() {
		return courseID;
	}
	
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	
	public Integer getColumnsID() {
		return columnsID;
	}
	
	public void setColumnsID(Integer columnsID) {
		this.columnsID = columnsID;
	}
	


}
