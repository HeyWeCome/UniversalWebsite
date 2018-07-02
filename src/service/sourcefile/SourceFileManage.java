package service.sourcefile;

import dao.GeneralDao;
import entity.SourceFile;
import util.InSertDBUtil;

/** 
 * @ClassName:     SourceFileManage.java 
 * @Description:   资源文件的管理类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:20:49  
 */
public class SourceFileManage implements ISourcefileManage{

	/**  
	 * @Title:        saveResource  
	 * @Description:  上传文件资源的保存方法 
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:21:16  
	 */  
	@Override
	public Integer saveResource(SourceFile newSource) {
		// 将文件资源的内容获取出来
		Integer articleID = newSource.getId();
		// 保存的路径
		String path = newSource.getPath();
		// 获取资源的名称
		String name = newSource.getName();
		
		String sql = null;
		try {
			sql = GeneralDao.generalInsertSQL(newSource);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		try {
			Integer result = InSertDBUtil.insert(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
