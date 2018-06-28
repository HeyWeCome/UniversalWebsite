package dao;

import java.lang.reflect.Field;

/**
 * 通用方法类
 * @ClassName:     GeneralDao.java 
 * @Description:   TODO(用一句话描述该文件做什么)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018年6月27日 下午10:31:23
 */
public class GeneralDao {
	
	/**
	 * 假装是个通用的查找方法
	 * @return
	 */
	public static String generalSearchSQL(){
//		return "Select * from "+obj.getClass().getSimpleName()+";";
		return "Select * from teacher;";
	}
	
	/**
	 * 通用的插入方法
	 * @param obj
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static String generalInsertSQL(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Class clazz = obj.getClass();
		// 存放属性值
		Field[] fields = clazz.getDeclaredFields();
		
		StringBuffer sql = new StringBuffer();
		sql.append("Insert into ");
		sql.append(clazz.getSimpleName());
		sql.append(" (");
		
		for(Field field:fields){
			if("id".equals(field.getName())){
				continue;
			}
			sql.append(field.getName()).append(",");
		}
		
		// 去掉最后一个逗号
		sql.deleteCharAt(sql.length()-1);
		sql.append(") values (");
		
		for(Field field:fields){
			
			if("id".equals(field.getName().toLowerCase())){
				continue;
			}
			
			field.setAccessible(true);
			// 判断是否为空，为空的话不能使用toString方法
			if(field.get(obj) == null){
				continue;
			}else{
				Object value = field.get(obj);
				
				// 判断值是什么类型
				if(value instanceof String){
					sql.append("'").append(value).append("',");
				}else{
					sql.append(value).append(",");
				}
			}
			
		}
		
		//去掉最后一个逗号
		sql.deleteCharAt(sql.length()-1);
		sql.append(");");
		
		return sql.toString();
	}
	
	/**
	 * 修改的通用sql
	 * @param obj
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String generalUpdateSQL(Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class clazz = obj.getClass();
		// 存放属性值
		Field[] fields = clazz.getDeclaredFields();
		
		StringBuffer sql = new StringBuffer();
		sql.append("Update ");
		sql.append(clazz.getSimpleName());
		sql.append(" set ");
		
		for(Field field:fields){
			
			field.setAccessible(true);
			Object value = field.get(obj);
			if(value instanceof String){
				sql.append(field.getName()).append(" = '").append(field.get(obj).toString()).append("' , ");
			}else{
				sql.append(field.getName()).append(" = ").append(field.get(obj).toString()).append(" , ");
			}
		}
		
		// 去掉最后一个逗号
		sql.deleteCharAt(sql.length()-2);
		// 注意要使用getDeclaredField方法 getField只会返回公有变量，不会返回私有变量
		Field getId = clazz.getDeclaredField("id");
		getId.setAccessible(true);
		sql.append(" where id = ").append(getId.get(obj).toString()).append(";");
		return sql.toString();
	}
	
	/**
	 * 删除的通用方法
	 * @param obj
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static String generalDeleteSQL(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class clazz = obj.getClass();
		
		StringBuffer sql = new StringBuffer();
		sql.append("Delete From Teacher where id = ");
		Field getId = clazz.getDeclaredField("id");
		getId.setAccessible(true);
		sql.append(getId.get(obj).toString()).append(";");
		
		return sql.toString();
	}
}
