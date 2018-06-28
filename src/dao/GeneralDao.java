package dao;

import java.lang.reflect.Field;

/**
 * ͨ�÷�����
 * @ClassName:     GeneralDao.java 
 * @Description:   TODO(��һ�仰�������ļ���ʲô)  
 * @author         Vico.Ho 
 * @version        V1.0   
 * @Date           2018��6��27�� ����10:31:23
 */
public class GeneralDao {
	
	/**
	 * ��װ�Ǹ�ͨ�õĲ��ҷ���
	 * @return
	 */
	public static String generalSearchSQL(){
//		return "Select * from "+obj.getClass().getSimpleName()+";";
		return "Select * from teacher;";
	}
	
	/**
	 * ͨ�õĲ��뷽��
	 * @param obj
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static String generalInsertSQL(Object obj) throws IllegalArgumentException, IllegalAccessException{
		Class clazz = obj.getClass();
		// �������ֵ
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
		
		// ȥ�����һ������
		sql.deleteCharAt(sql.length()-1);
		sql.append(") values (");
		
		for(Field field:fields){
			
			if("id".equals(field.getName().toLowerCase())){
				continue;
			}
			
			field.setAccessible(true);
			// �ж��Ƿ�Ϊ�գ�Ϊ�յĻ�����ʹ��toString����
			if(field.get(obj) == null){
				continue;
			}else{
				Object value = field.get(obj);
				
				// �ж�ֵ��ʲô����
				if(value instanceof String){
					sql.append("'").append(value).append("',");
				}else{
					sql.append(value).append(",");
				}
			}
			
		}
		
		//ȥ�����һ������
		sql.deleteCharAt(sql.length()-1);
		sql.append(");");
		
		return sql.toString();
	}
	
	/**
	 * �޸ĵ�ͨ��sql
	 * @param obj
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static String generalUpdateSQL(Object obj) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		Class clazz = obj.getClass();
		// �������ֵ
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
		
		// ȥ�����һ������
		sql.deleteCharAt(sql.length()-2);
		// ע��Ҫʹ��getDeclaredField���� getFieldֻ�᷵�ع��б��������᷵��˽�б���
		Field getId = clazz.getDeclaredField("id");
		getId.setAccessible(true);
		sql.append(" where id = ").append(getId.get(obj).toString()).append(";");
		return sql.toString();
	}
	
	/**
	 * ɾ����ͨ�÷���
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
