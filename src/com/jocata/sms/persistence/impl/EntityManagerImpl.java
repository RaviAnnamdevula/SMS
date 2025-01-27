package com.jocata.sms.persistence.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jocata.sms.database.FileSystem;
import com.jocata.sms.persistence.EntityManager;

@SuppressWarnings("rawtypes")
public class EntityManagerImpl implements EntityManager {

	@Override
	public boolean save(Class clazz, Object entity) {
		try {
			return FileSystem.writeDataToFile(entity, clazz);
		} catch (Exception e) {
			e.printStackTrace();;
			return false;
		}
	}

	@Override
	public List<Object> get(Class clazz) {
		try {
			Map<String, List<Object>> data = FileSystem.getDataMap();
			return data.getOrDefault(clazz.getName(), new ArrayList<>());
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return null;
	}

	@Override
	public Object get(Class clazz, Object primaryKeyName, Object primaryKeyValue) {
		try {
			Map<String, List<Object>> data = FileSystem.getDataMap();
			List<Object> lstData = data.getOrDefault(clazz.getName(), new ArrayList<>());
			for (Object object : lstData) {
				Object fieldValue = getPrimaryKeyValue(clazz, object, primaryKeyName);
				if (fieldValue != null && (fieldValue.equals(primaryKeyValue))) {
					return object;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Object> get(Class clazz, Object... obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Class clazz, Object entity) {
		try {
			FileSystem.updateDataToFile(entity, clazz);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void delete(Class clazz, Object entity) {
		try {
			FileSystem.deleteDataToFile(entity, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Object getPrimaryKeyValue(Class clazz, Object object, Object primaryKeyName) throws NoSuchFieldException, IllegalAccessException {
	    
		String primaryKeyFieldName = (String) primaryKeyName;
	    java.lang.reflect.Field field = clazz.getDeclaredField(primaryKeyFieldName);
	    field.setAccessible(true);
	    return field.get(object);
	}
}
