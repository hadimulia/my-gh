package com.app.generic.core.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Table;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;


/**
 * An utility class that helps to retrieve database metadata from hibernate and jdbc connection. 
 * e.g. column name, table name, table contents.
 * 
 * @author josua.napitupulu
 * @version 1.0, 5/31/12 10:00 AM
 */
@Component
public class DatabaseMetaDataUtil {

	/**
	 * a variable to define package name that stores entity model in this project. 
	 */
	public static final String MODEL_PACKAGE = "com.anabatic.psak.model";
	
	/**
	 * Gets a list of field names in the given class from package <code>MODEL_PACKAGE</code>. 
	 * The collection contains all fields that have setter and getter.
	 * 
	 * @param clazz Class name 
	 * @return A list of string
	 */
	public static <T> List<String> getColumns(Class<T> clazz)
	{
		List<String> columns = new ArrayList<String>();
		
		/* loop until the class is not from package model. To get fields from its parent class */
		List<Field> fields = getFields(clazz);
		for (Field field : fields) {
			columns.add(field.getName());
		}
			
		return columns;
	}
	
	/**
	 * Gets a list of database column name from a given class from package <code>MODEL_PACKAGE</code>.
	 * The name is retrieve from annotation @Column on the getter method.
	 * 
	 * @param clazz class name
	 * @return a list of string
	 */
	public static <T> List<String> getDatabaseColumnsName(Class<T> clazz)
	{
		List<String> columns = new ArrayList<String>();
		
		/* loop until the class is not from package model. To get fields from its parent class */
		List<Field> fields = getFields(clazz);
		for (Field field : fields) {
			String name = null;
			try {
				Column annotationColumn = new PropertyDescriptor(field.getName(), clazz).getReadMethod().getAnnotation(Column.class);
				if (annotationColumn != null)
					name = annotationColumn.name();
			} catch (IntrospectionException e) {

			}
			if(name!=null)
				columns.add(name);
		}
			
		return columns;
	}
	
	public static <T> List<String> getDatabaseColumnsName(String className) throws ClassNotFoundException
	{
		return getDatabaseColumnsName(Class.forName(className));
	}
	
	/**
	 * Gets a list of field names in the given class. 
	 * The collection contains all fields that have setter and getter.
	 * 
	 * @param className class name with its package name.
	 * @return a list of string column name
	 * @throws ClassNotFoundException 
	 */
	public static List<String> getColumns(String className) throws ClassNotFoundException
	{
		return getColumns(Class.forName(className));
	}
	
	/**
	 * Gets a list of class name from a list of class name with package.
	 * e.g. com.anabatic.psak.model.DataSource => DataSource
	 * 
	 * @param classString a list of string class name with package name.
	 * @return a list of string class name
	 */
	public static List<String> removePackageFromClassString(List<String> classString)
	{
		List<String> strings = new ArrayList<String>();
		for (String string : classString) {
			String[] split = string.split("\\.");
			strings.add(split[split.length-1]);
		}
		return strings;
	}
	
	/**
	 * Gets all table names from given jdbc properties. 
	 * 
	 * @param url driver url
	 * @param username database username
	 * @param password database password
	 * @param dbms database type see {@link com.anabatic.psak.enumeration.DatabaseTypeEnum}
	 * @return a list of table names
	 * @throws SQLException
	 */
	public static List<String> getTableNames(String url, String username, String password, int dbms) throws SQLException
	{
		List<String> strings = new ArrayList<String>();
		Connection con = DriverManager.getConnection(url, username, password);
		String sql = "";
		if(dbms == DatabaseTypeEnum.MySql.getType())
			sql = "show tables";
		if(dbms == DatabaseTypeEnum.MsSQL.getType())
			sql = "SELECT distinct TABLE_NAME FROM INFORMATION_SCHEMA.COLUMNS ORDER BY TABLE_NAME";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while(rs.next())
		{
			strings.add(rs.getString(1));
		}
		con.close();
		return strings;
	}
	
	/**
	 * Gets all table names from given jdbc properties.
	 * 
	 * @param url driver url
	 * @param username database username
	 * @param password database password
	 * @param dbms database type see {@link com.anabatic.psak.enumeration.DatabaseTypeEnum}
	 * @param table table name
	 * @return a list of table names
	 * @throws SQLException
	 */
	public static List<String> getColumnNames(String url, String username, String password, int dbms, String table) throws SQLException
	{
		List<String> strings = new ArrayList<String>();
		Connection con = DriverManager.getConnection(url, username, password);
		String sql = "";
		if(dbms == DatabaseTypeEnum.MySql.getType())
			sql = "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME = '"+ table +"';";
		if(dbms == DatabaseTypeEnum.MsSQL.getType())
			sql = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='" + table + "' ORDER BY COLUMN_NAME";
		ResultSet rs = con.createStatement().executeQuery(sql);
		while(rs.next())
		{
			strings.add(rs.getString(1));
		}
		con.close();
		return strings;
	}
	
	/**
	 * Gets column rows from given jdbc properties.
	 * 
	 * @param urldriver url
	 * @param username database username
	 * @param password database password
	 * @param dbms database type see {@link com.anabatic.psak.enumeration.DatabaseTypeEnum}
	 * @param table table name
	 * @param column column name
	 * @param totalRow number of rows retrieved
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> getColumnContent(String url, String username, String password, String table, String column, int totalRow) throws SQLException
	{
		List<Object> objects = new ArrayList<Object>();
		Connection con = DriverManager.getConnection(url, username, password);
		String sql = "";
		sql = "SELECT " + column + " FROM "+ table;
		ResultSet rs = con.createStatement().executeQuery(sql);
		int i=1;
		while(rs.next())
		{
			objects.add(rs.getObject(1));
			if(i==totalRow) break;
			i++;
		}
		con.close();
		return objects;
	}

	/**
	 * 
	 * @param clazz
	 * @return 
	 */
	public static <T> String getTableName(Class<T> clazz){
	   Table table = AnnotationUtils.findAnnotation(clazz, Table.class);    
		return table.name();
	}
	
	public static <T> Map<String, String> getFieldMapper(Class<T> clazz)
	{
		Map<String, String> result = new HashMap<String, String>();
		
		List<Field> fields = getFields(clazz);
		
		for (Field field : fields) {
			Column annotationColumn; 
			try {
				annotationColumn = new PropertyDescriptor(field.getName(), clazz).getReadMethod().getAnnotation(Column.class);
				if(annotationColumn != null)
					 result.put(annotationColumn.name(), field.getName());
			} catch (IntrospectionException e) { }
		}
		return result;
	}
	
	public static <T> Map<String, String> getFieldJoinMapper(Class<T> clazz)
	{
		Map<String, String> result = new HashMap<String, String>();
		
		List<Field> fields = getFields(clazz);	
		
		for (Field field : fields) {
			Column annotationColumn;
			JoinColumns joinColumns;
			try {
				
				annotationColumn = new PropertyDescriptor(field.getName(), clazz).getReadMethod().getAnnotation(Column.class);
				if(annotationColumn != null)
					 result.put(annotationColumn.name(), field.getName());
				joinColumns = new PropertyDescriptor(field.getName(), clazz).getReadMethod().getAnnotation(JoinColumns.class);
				
				if(joinColumns != null)
				{
					JoinColumn[] listColumn = joinColumns.value();
					
					if(listColumn.length != 0){
						for (JoinColumn joinColumn : listColumn) {
							result.put(joinColumn.name(), joinColumn.name());
							System.out.println("Join Column " + joinColumns.value().toString() + " with reference " + joinColumns.value().length );	
						}
					}
				}
					
			} catch (IntrospectionException e) { }
		}
		return result;
	}
	
	public static Object getObjectWithProperties(String className, Map<String, Object> properties) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		className = MODEL_PACKAGE + "." + className;
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName(className);
		Object object = clazz.newInstance();
		for (Entry<String, Object> entry : properties.entrySet()) {
			List<Field> fields = getFields(clazz);
			
			for (Field field : fields) {
				Column annotationColumn;
				try {
					annotationColumn = new PropertyDescriptor(field.getName(), clazz).getReadMethod().getAnnotation(Column.class);
					if (annotationColumn != null)
						if(annotationColumn.name().equals(entry.getKey()))
						{
							field.setAccessible(true);
							if(entry.getValue() != null)
								field.set(object, ObjectConverterUtil.convertObject(field.getType(), entry.getValue()) );
						}
				} catch (IntrospectionException e) {}
			}
		}
		return object;
	}
	@SuppressWarnings("rawtypes")
	public static List<Field> getFields(Class clazz)
	{
		List<Field> columns = new ArrayList<Field>();
		boolean loop = true;
		
		/* loop until the class is not from package model. To get fields from its parent class */
		while(loop)
		{
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				columns.add(field);
			}
			
			/* change the class to its parent if the parent class is from package model */
			if(clazz.getSuperclass().getPackage().getName().equals(MODEL_PACKAGE))
				clazz = (Class) clazz.getSuperclass();
			else
				loop = false;
		}
		
		return columns;
	}
	@SuppressWarnings("rawtypes")
	public static Object getValue(Object object, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		Class clazz = object.getClass();
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		@SuppressWarnings("unused")
		Object result = field.get(object);
		return field.get(object);
	}
	@SuppressWarnings("rawtypes")
	public static void setValue(Object object, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException
	{
		Class clazz = object.getClass();
		String[] fields = fieldName.split("\\.");
		if(fields.length>1){
			Object tmp = getValue(object, fields[0]);
			Field field = clazz.getDeclaredField(fields[0]);
			if(tmp==null){
				tmp = field.getType().newInstance();
			}		
			setValue(tmp, fieldName.substring(fieldName.indexOf(".")+1), value);
			
			field.setAccessible(true);
			field.set(object, tmp);
		}else{
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(object, value);
		}
		
//		Field field = null;
//		try{
//			field = clazz.getDeclaredField(fieldName);
//		}catch(NoSuchFieldException noField){
			
//			Object tmp = getValue(object, fields[0]);
//			if(tmp==null){
//				tmp = tmp.getClass().newInstance();
//			}		
//			setValue(tmp, fields[0], value);
//		}
//		field.setAccessible(true);
//		field.set(object, value);
	
	}
	@SuppressWarnings("rawtypes")
	public static List<Method> getMethods(Class clazz){
		List<Method> allMethods = new ArrayList<Method>();
		boolean loop = true;
		while(loop){
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				allMethods.add(method);
			}
			if(clazz.getSuperclass().getPackage().getName().equals(MODEL_PACKAGE))
				clazz = (Class) clazz.getSuperclass();
			else
				loop = false;
		}
		return allMethods;
	}
	public enum DatabaseTypeEnum {

		MySql(1,"MySql"), MsSQL(2,"Microsoft SQL");
		
		private int type;
		private String name;
		
		private DatabaseTypeEnum(int type, String name)
		{
			this.type = type;
			this.name = name;
		}
		
		public int getType()
		{
			return type;
		}
		
		public String getName()
		{
			return name;
		}
	}

}
