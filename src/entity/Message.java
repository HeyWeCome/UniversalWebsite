package entity;

/**
 * 
 * @ClassName:     Message.java 
 * @Description:   留言类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午9:56:23
 */
public class Message {
	private String id;
	private String content;
	private String createTime;
	private String reply;
	private String employeeID;
	private String replyTime;
	private String status;
	private String moduleID;
	
	/**
	 * 默认构造方法
	 */
	public Message() {
		super();
	}

	/**
	 * 含参构造方法
	 * @param id
	 * @param content
	 * @param createTime
	 * @param reply
	 * @param employeeID
	 * @param replyTime
	 * @param status
	 * @param moduleID
	 */
	public Message(String id, String content, String createTime, String reply, String employeeID, String replyTime,
			String status, String moduleID) {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
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

	public String getModuleID() {
		return moduleID;
	}

	public void setModuleID(String moduleID) {
		this.moduleID = moduleID;
	}
	
	
}
