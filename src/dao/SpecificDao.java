package dao;

import entity.Article;
import entity.Columns;
import entity.Employee;
import entity.Message;
import entity.Module;
import entity.Permission;
import entity.Role;
import entity.SonColumns;
import entity.SonModule;

/**
 * 
 * @ClassName:     SpecificDao.java 
 * @Description:   特殊的sql语句生成类 
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月29日 下午2:53:23
 */
public class SpecificDao {
	/**
	 * 
	 * @Title:        whetherAccountInTable  
	 * @Description:  判断账号是否存在  
	 * @param:        @param account
	 * @param:        @param passWord
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:53:43
	 */
	public static String whetherAccountInTable(String account, String passWord, String tableName){
		return "select * from "+tableName+" where account = '"+account+"' and passWord = '"+passWord+"';";
	}

	/**
	 * 
	 * @Title:        selectAllFromTable  
	 * @Description:  返回指定table所有的内容 
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午2:53:59
	 */
	public static String selectAllFromTable(String tableName){
		return "select * from "+tableName+";";
	}

	public static String selectAllModule(){
		return "select * from module where status = '1';";
	}
	
	/**
	 * 
	 * @Title:        selectAccessSonColumns  
	 * @Description: 根据用户名找到相对应模块的信息
	 * @param:        @param userName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午4:45:23
	 */
	public static String selectAccessSonColumns(String userName){
		return "select sonmodule.id,sonmodule.name,sonmodule.parentModuleID "
				+ "from employee,role,permission,sonmodule "
				+ "where employee.roleID = role.id "
				+ "and role.id = permission.roleID "
				+ "and status ='1' "
				+ "and employee.name = '"+userName+"' "
				+ "and permission.moduleID = sonmodule.id;";
	}
	/**
	 * 
	 * @Title:        selectAllArticle  
	 * @Description:  选择所有的文章,按照前台指定格式返回
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午3:00:43
	 */
	public static String selectAllArticle(){
		String sql = "SELECT" +
				"	article.title," +
				"	employee.NAME AS roleName," +
				"	sonColumns.NAME AS columnsName," +
				"	article.createTime," +
				"	article.whetherTop " +
				"FROM " +
				"	article," +
				"	sonColumns," +
				"	employee " +
				"WHERE " +
				"article.columnID = sonColumns.id " +
				"AND article.employeeID = employee.id";

		return sql;

	}

	/**
	 * 
	 * @Title:        selectAllArticle  
	 * @Description:  选择所有的文章,按照前台指定格式返回
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午3:00:43
	 */
	public static String selectAllAuditArticle(){
		String sql = "SELECT" +
				"	article.title," +
				"	employee.NAME AS roleName," +
				"	sonColumns.NAME AS columnsName," +
				"	article.createTime," +
				"	article.whetherTop, " +
				"	article.status " +
				"FROM " +
				"	article," +
				"	sonColumns," +
				"	employee " +
				"WHERE " +
				"article.columnID = sonColumns.id " +
				"AND article.employeeID = employee.id;";

		return sql;

	}


	/**
	 * 
	 * @Title:        findUserName  
	 * @Description:  根据账号密码找到用户名
	 * @param:        @param account
	 * @param:        @param passWord
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午1:26:44
	 */
	public static String findUserName(String account, String passWord){
		// 生成sql
		return "select name from employee where account = '"+account+"' and passWord = '"+passWord+"';";

	}


	/**
	 * 
	 * @Title:        findIDFromTable  
	 * @Description:  根据名称从指定表中返回ID
	 * @param:        @param name
	 * @param:        @param tableName
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午4:23:36
	 */
	public static String findIDFromTable(String name,String tableName){
		// 生成sql
		String sql = "select id from "+tableName+" where name = '"+name+"'";

		return sql;
	}

	/**
	 * 
	 * @Title:        deleteArticle  
	 * @Description:  删除文章对象 
	 * @param:        @param articleName
	 * @param:        @param authorID
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月29日 下午5:16:10
	 */
	public static String deleteArticle(Integer authorID, String title){
		String sql = "delete from article where employeeID = "+authorID
				+" and title = '"+title+"';";
		return sql;
	}


	/**
	 * 
	 * @Title:        deletRole  
	 * @Description:  删除角色
	 * @param:        @param roleID
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午6:10:49
	 */
	public static String deletRole(Integer roleID){
		String sql = "delete from role where id = "+roleID+";";
		return sql;
	}
	/**
	 * 
	 * @Title:        passArticle  
	 * @Description:  修改文章状态的sql 
	 * @param:        @param article
	 * @param:        @param employeeID
	 * @param:        @param status
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午4:04:04
	 */
	public static String passArticle(String article, Integer employeeID, String status){
		return "update Article "+
				" SET status = '"+status+"' "+
				" where title = '"+article+"'"+
				" and employeeID = "+employeeID+";";

	}

	/**
	 * 
	 * @Title:        findAllEmployee  
	 * @Description:  查询所有的人员  
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:11:53
	 */
	public static String findAllEmployee(){
		return "select employee.name,employee.sex,employee.account,employee.passWord,role.name as roleName "
				+ "from employee,role "
				+ "where employee.roleID = role.id";
	}

	/**
	 * 
	 * @Title:        findArticleContent  
	 * @Description:  找寻指定文章内容
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午9:49:08
	 */
	public static String findArticleContent(String title, Integer employeeID){
		return "select article.content "
				+" from article "
				+ " where article.title = '"+title
				+ "' and article.employeeID = "+employeeID;
	}

	/**
	 * 
	 * @Title:        updateArticle  
	 * @Description:  更新文章 
	 * @param:        @param article
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午11:23:25
	 */
	public static String updateArticle(Article article){
		// 获取文章标题
		String title = article.getTitle();
		// 获取作者ID
		Integer authorID = article.getEmployeeID();
		// 获取子栏目
		Integer columnID = article.getColumnID();
		// 获取是否置顶
		String whetherTop = article.getWhetherTop();
		// 获取文章内容
		String content = article.getContent();

		return "update Article"+
				" SET title = '"+title+"', "+
				" employeeID = "+authorID+", "+
				" columnID = "+columnID+", "+
				" whetherTop = '"+whetherTop+"', "+
				" content = '"+content+"' "+
				" where title = '"+title+"'"+
				" and employeeID = "+authorID+";";
	}
	
	/**
	 * 
	 * @Title:        updateRole  
	 * @Description:  更新角色
	 * @param:        @param role
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年6月30日 下午11:23:48
	 */
	public static String updateRole(Role role){
		// 获取角色ID
		String name = role.getName();	
		// 获取角色描述
		String description = role.getDescription();

		return "update Role"+
				" SET name = '"+name+"', "+
				" description = '"+description+"' "+
				" where name = '"+name+"';";
	}
	
	/**
	 * 
	 * @Title:        deleteEmployee  
	 * @Description:  删除员工
	 * @param:        @param employee
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午1:03:00
	 */
	public static String deleteEmployee(Employee employee){
		return "delete from employee where name = '"+employee.getName()+"'"
				+ " and account = '"+employee.getAccount()+"';";
	}
	
	/**
	 * 
	 * @Title:        deleteExistingPermission  
	 * @Description:  删除一个账号已有的权限 
	 * @param:        @param permission
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午1:39:46
	 */
	public static String deleteExistingPermission(Permission permission){
		return "delete from permission where roleID = "+permission.getRoleID()+";";
	}

	/**
	 * 
	 * @Title:        findExistingPermission  
	 * @Description:  找到用户对应的所有权限
	 * @param:        @param permission
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午2:02:39
	 */
	public static String findExistingPermission(Permission permission){
		return "select moduleID from permission where roleID = "+permission.getRoleID()+";";
	}
	
	/**
	 * 
	 * @Title:        updateEmployee  
	 * @Description:  更新员工
	 * @param:        @param employee
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午4:13:06
	 */
	public static String updateEmployee(Employee employee){
		return "update employee "
				+ "set name = '"+employee.getName()+"', "
				+ " sex = '"+employee.getSex()+"', "
				+ " passWord = '"+employee.getPassWord()+"', "
						+ "roleID = "+employee.getRoleID()+" "
								+ "where account = '"+employee.getAccount()+"';";
	}
	
	/**
	 * 
	 * @Title:        findAllMessage  
	 * @Description:  找到所有的留言 
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午4:37:15
	 */
	public static String findAllMessage(){

		return "select content,createTime,reply,replyTime,employee.name as replyEmployee,status "
				+ "from message,employee "
				+ "where message.employeeID = employee.id ";
	}
	
	/**
	 * 
	 * @Title:        updateMessage  
	 * @Description:  更新留言 
	 * @param:        @param message
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月1日 下午8:30:46
	 */
	public static String updateMessage(Message message){
		return "update message "
				+ "set  reply = '"+message.getReply()+"', "
				+ "  employeeID = "+message.getEmployeeID()+", "
				+ " replyTime = '"+message.getReplyTime()+"', "
						+ "status = '"+message.getStatus()+"' "
								+ "where content = '"+message.getContent()+"';";
	}
	
	
	/**
	 * 
	 * @Title:        deleteMessage  
	 * @Description:  生成删除留言的sql语句  
	 * @param:        @param message
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 上午9:38:46
	 */
	public static String deleteMessage(Message message){
		return "delete from message"
				+ " where content = '"
				+ message.getContent()+"';";
	}
	
	/**
	 * 
	 * @Title:        findArticleID  
	 * @Description:  找到所有的文章 
	 * @param:        @param title
	 * @param:        @param authorID
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:44:23
	 */
	public static String findArticleID(String title, Integer authorID){
		return "select id from article "
				+ "where title = '"+title+"' "
						+ "and employeeID = "+authorID+";";
	}
	
	/**
	 * 
	 * @Title:        findAllPASColumns  
	 * @Description:  找到所有的父模块和子模块  
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午3:44:58
	 */
	public static String findAllPASModule(){
		return "select module.name as parentName,module.status as parentStatus,sonmodule.status as sonStatus,sonmodule.name as sonName "
				+ "from module,sonmodule "
				+ "where sonModule.parentModuleID = module.id;";
		
	}
	
	/**
	 * 
	 * @Title:        findAllPASColumns  
	 * @Description:  找到所有父栏目和子栏目 
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:50:34
	 */
	public static String findAllPASColumns(){
		return "select soncolumns.name as name, soncolumns.level as level, "
				+ "columns.name as parentName "
				+ "from soncolumns,columns "
				+ "where soncolumns.parentID = columns.id;";
		
	}
	
	
	/**
	 * 
	 * @Title:        updateModule  
	 * @Description:  更新模块表  
	 * @param:        @param module
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月2日 下午11:34:04
	 */
	public static String updateModule(Module module){
		return "update module "
				+ "set status = '"+module.getStatus()+"'"
//						+ " name = '"+module.getName()+"'"
						+ "where module.name = '"+module.getName()+"';";
	}
	
	public static String updateSonModule(SonModule sonmodule){
		return "update Sonmodule "
				+ "set status = '"+sonmodule.getStatus()+"'"
//						+ " name = '"+sonmodule.getName()+"'"
						+ " parentModuleID = "+sonmodule.getParentModuleID()+" "
								+ " where sonmodule.name = '"+sonmodule.getName()+";";
	}
	
	/**
	 * 
	 * @Title:        updateColumns  
	 * @Description:  更新栏目表
	 * @param:        @param columns
	 * @param:        @return     
	 * @return:       String     
	 * @throws  
	 * @author        Vico.Ho 
	 * @Date          2018年7月3日 上午12:24:52
	 */
	public static String updateColumns(Columns columns){
		return "update columns "
				+ "set name = '"+columns.getName()+"', "
				+ " level = '"+columns.getLevel()+"';";
	}
	
	public static String updateSonColumns(SonColumns soncolumns){
		return "update soncolumns "
				+ "set name = '"+soncolumns.getName()+"', "
				+ " level = '"+soncolumns.getLevel()+"',"
						+ " parentID = "+ soncolumns.getParentID()+";";
	}
}
