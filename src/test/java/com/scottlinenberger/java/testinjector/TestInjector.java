package com.scottlinenberger.java.testinjector;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public class TestInjector<O> {

	private O object;
	
	public TestInjector(O object){
		this.object = object;
	}
	
	public Object get(String fieldName) {
		Field field = ReflectionUtils.findField(object.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		return ReflectionUtils.getField(field, object);
	}
	
	public void set(String fieldName, Object value) {
		Field field = ReflectionUtils.findField(object.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, object, value);
	}
	
}
