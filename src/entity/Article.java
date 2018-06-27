package entity;

/**
 * @ClassName:     Article.java 
 * @Description:   文章实体类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:40:46
 */
public class Article {
	private String id;
	private String title;
	private String employeeID;
	private String columnID;
	private String content;
	private String createTime;
	private String whetherTop;
	private String status;
	
	/**
	 * 默认构造方法
	 */
	public Article() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param title
	 * @param employeeID
	 * @param columnID
	 * @param content
	 * @param createTime
	 * @param whetherTop
	 * @param status
	 */
	public Article(String id, String title, String employeeID, String columnID, String content, String createTime,
			String whetherTop, String status) {
		super();
		this.id = id;
		this.title = title;
		this.employeeID = employeeID;
		this.columnID = columnID;
		this.content = content;
		this.createTime = createTime;
		this.whetherTop = whetherTop;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getColumnID() {
		return columnID;
	}

	public void setColumnID(String columnID) {
		this.columnID = columnID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getWhetherTop() {
		return whetherTop;
	}

	public void setWhetherTop(String whetherTop) {
		this.whetherTop = whetherTop;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
