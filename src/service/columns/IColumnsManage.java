/**
 * 
 */
package service.columns;

import entity.Columns;
import entity.SonColumns;

/**
 * 
 * @ClassName:     IColumnsManage.java 
 * @Description:   栏目管理接口类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年7月2日 下午3:40:54
 */
public interface IColumnsManage {
	String getAllColumns();
	String getAllSonColumns();
	String getAllPASColumns();
	Integer updateColumns(Columns columns);
	Integer updateSonColumns(SonColumns sonColumns);
	Integer insertColumn(Columns columns);
	Integer insertSonColumns(SonColumns sonColumns);
	Integer deleteColumns(Columns columns);
	Integer deleteSonColumns(SonColumns soncolumns);
	String findAllArticle(SonColumns soncolumns);
}
