/**
 * 
 */
package service.course;

import dao.SpecificDao;
import util.DBUtil;

/** 
 * @ClassName:     CourseManage.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午7:56:12  
 */
public class CourseManage implements ICourseManage{

	/**  
	 * @Title:        findAllCourse  
	 * @Description:  返回所有的课程 
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午7:56:36  
	 */  
	@Override
	public String findAllCourse() {
		String sql = SpecificDao.selectAllFromTable("course");
		// 存储从数据库中查找到的数据
		String result = null;
		
		try {
			result = DBUtil.findAllCourse(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
