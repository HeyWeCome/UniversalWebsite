/**
 * 
 */
package service.CourseColumns;
import entity.CourseColumns;
import util.DBUtil;
/** 
 * @ClassName:     CourseColumns.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月3日 下午2:50:25  
 */
public class CourseColumnsManage implements ICourseColumnsManage{

	/**  
	 * @Title:        findSoncolumns  
	 * @Description:  找到给定课程父栏目对应的子栏目 
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午2:53:16  
	 */  
	@Override
	public String findSoncolumns(CourseColumns courseColumns) {
		// 获取到给定属性
		Integer courseID = courseColumns.getCourseID();
		Integer columnsID = courseColumns.getColumnsID();

		String sql = "select soncolumns.id,soncolumns.name "
				+ " from courseColumns,columns,soncolumns "
				+ "where courseColumns.columnsID = columns.id and "
				+ "soncolumns.parentID = columns.id and "
				+ "courseID = "+courseID+" and "
				+ "columnsID = "+columnsID+";";

		System.out.println("需要执行的sql为:"+sql);
		try {
			String result = DBUtil.homePagefindAllSonColumns(sql);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**  
	 * @Title:        findAllResources  
	 * @Description:  课程栏目管理
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 下午3:19:16  
	 */  
	@Override
	public String findAllResources(CourseColumns courseColumns) {
		// 获取到给定属性
		Integer courseID = courseColumns.getCourseID();
		
		String sql = "select article.title, sourcefile.name";
		return null;
	}



}
