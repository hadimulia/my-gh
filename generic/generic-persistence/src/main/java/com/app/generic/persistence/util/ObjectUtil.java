package com.app.generic.persistence.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.annotation.Id;

import com.app.generic.persistence.model.GenericModel;

/**
 * Object formatting
 * 
 * @author Taufik Muliahadi (taufik.muliahadi &copy;Dec 7, 2018) <br>
 *
 */
public class ObjectUtil {
	private static Logger logger = LogManager.getLogger(ObjectUtil.class);

	/**
	 * showField is for returning Map that has a Key as Field Name and Value from
	 * the Object Field.
	 * 
	 * @param param the Object
	 * @return Map&lt;String, &gt; <b>&lt;Field Name & Value&gt;</b>
	 */
	public static Map<String, Object> showFields(Object param) {
		Map<String, Object> fields = new HashMap<>();
		try {
			for (Field field : param.getClass().getDeclaredFields()) {
				// you can also use .toGenericString() instead of .getName(). This will
				// give you the type information as well.
				field.setAccessible(true);
				fields.put(field.getName(), field.get(param));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fields;
	}

	/**
	 * Return field object that you find.
	 *
	 * @param obj   the object that you want to find.
	 * @param field name on the object.
	 * @return
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static Object getField(Object obj, String field) throws NoSuchFieldException, IllegalAccessException {
		Object fieldObject = null;
		Field fieldValue = null;
		fieldValue = obj.getClass().getDeclaredField(field);
		fieldValue.setAccessible(Boolean.TRUE);

		fieldObject = fieldValue.get(obj);
		return fieldObject;
	}

	/**
	 * Getting Identity on the argument object that have &#64;Param
	 *
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, String> getIdentity(Object[] objs) throws IllegalAccessException {
		Map<String, String> result = new HashMap<>();
		for (Object object : objs) {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if ((field.getAnnotation(Id.class) != null)
						|| (field.getAnnotation(javax.persistence.Id.class) != null)) {
					if (field.get(object) != null) {
						result.put(object.getClass().getName(), field.get(object).toString());
					}
					break;
				}
			}
		}
		return result;
	}

	/**
	 * Getting Identity on the argument object that have &#64;Param
	 *
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, String> getIdentity(Object objs) throws IllegalAccessException {
		Map<String, String> result = new HashMap<>();
		Field[] fields = objs.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if ((field.getAnnotation(Id.class) != null) || (field.getAnnotation(javax.persistence.Id.class) != null)) {
				result.put(objs.getClass().getName(), field.get(objs).toString());
				break;
			}
		}
		return result;
	}

	/**
	 * Getting Identity on the argument object that have &#64;Param
	 *
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getIdentityValue(Object objs) throws IllegalAccessException {
		Object result = null;
		if (objs instanceof Number) {
			return objs;
		} else {
			Field[] fields = objs.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if ((field.getAnnotation(Id.class) != null)
						|| (field.getAnnotation(javax.persistence.Id.class) != null)) {
					result = field.get(objs);
					break;
				}
			}
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getModelWithoutBaseModel(T t) {
		Object obj = t;
		try {
			for (Field field : GenericModel.class.getDeclaredFields()) {
				if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
					field.setAccessible(Boolean.TRUE);
					field.set(obj, null);
				}
			}
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		}
		return (T) obj;
	}
}
