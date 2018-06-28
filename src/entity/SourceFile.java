package entity;

/**
 * 
 * @ClassName:     SourceFile.java 
 * @Description:   资源类
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午10:07:25
 */
public class SourceFile {
	private Integer id;
	private Integer articleID;
	private String path;
	
	public SourceFile() {
		super();
	}

	public SourceFile(Integer id, Integer articleID, String path) {
		super();
		this.id = id;
		this.articleID = articleID;
		this.path = path;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArticleID() {
		return articleID;
	}

	public void setArticleID(Integer articleID) {
		this.articleID = articleID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
