package entity;

/**
 * 
 * @ClassName:     Message.java 
 * @Description:  	留言类  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午7:57:26
 */
public class Message {
	private Integer id;
	private String content;
	private String createTime;
	private String reply;
	private Integer employeeID;
	private String replyTime;
	private String status;
	private Integer moduleID;
	private Integer courseID;

	public Message() {
		super();
	}

	/**
	 * @param id
	 * @param content
	 * @param createTime
	 * @param reply
	 * @param employeeID
	 * @param replyTime
	 * @param status
	 * @param moduleID
	 */
	public Message(Integer id, String content, String createTime, String reply, Integer employeeID, String replyTime,
			String status, Integer moduleID) {
		super();
		this.id = id;
		this.content = content;
		this.createTime = createTime;
		this.reply = reply;
		this.employeeID = employeeID;
		this.replyTime = replyTime;
		this.status = status;
		this.moduleID = moduleID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCourseID() {
		return courseID;
	}

	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getModuleID() {
		return moduleID;
	}

	public void setModuleID(Integer moduleID) {
		this.moduleID = moduleID;
	}
	
	
}
