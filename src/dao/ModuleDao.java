/**
 *FileName:Module.java
 * @author:lmy
 *Creatdate:2018年6月28日上午10:17:40
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Module;
import entity.SonModule;

/**
 * @author lmy
 *
 */
public class ModuleDao {
	private static ModuleDao moduleDao;
	
	public static ModuleDao getModuleDao(){
		if (moduleDao == null){
			moduleDao = new ModuleDao();
		}
		
		return moduleDao;
	}
	
	public List listParent(){
		String sql = "select * from module";
		List<Module> resultList = new ArrayList<>();
		ResultSet result = null;	
		
		try {
			result = DBUtil.returnList(sql);
			//result.last();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			while(result.next()){
				Module module = new Module();
				
				module.setId(result.getInt("id"));
				module.setName(result.getString("name"));
				module.setStatus(result.getString("status"));
				
				
				resultList.add(module);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
		
	}
	
	public List listSon(){
		String sql = "select * from sonmodule";
		List<SonModule> resultList = new ArrayList<>();
		ResultSet result = null;	
		
		try {
			result = DBUtil.returnList(sql);
			//result.last();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			while(result.next()){
				SonModule module = new SonModule();
				
				module.setId(result.getInt("id"));
				module.setName(result.getString("name"));
				module.setStatus(result.getString("status"));
				module.setParentModuleID(result.getInt("parentModuleID"));
				
				resultList.add(module);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultList;
		
	}
}
