/**
 * 
 */
package service.sourcefile;

import entity.SourceFile;

/** 
 * @ClassName:     ISourcefileManage.java 
 * @Description:   上传资源保存到数据库
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:19:00  
 */
public interface ISourcefileManage {
	String saveResource(SourceFile newSource);
}
