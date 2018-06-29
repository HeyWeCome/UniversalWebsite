package entity;

/**
 * 
 * @ClassName:     SourceFile.java 
 * @Description:   资源文件 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:15:10
 */
public class SourceFile {
	private Integer id;
	private Integer articleID;
	private String path;
	private String name;
	
	public SourceFile() {
		super();
	}

	public SourceFile(Integer id, Integer articleID, String path) {
		super();
		this.id = id;
		this.articleID = articleID;
		this.path = path;
	}

	
	public SourceFile(Integer id, Integer articleID, String path, String name) {
		super();
		this.id = id;
		this.articleID = articleID;
		this.path = path;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
