package com.scottlinenberger.java.testinjector;

import java.lang.reflect.Field;

import org.springframework.util.ReflectionUtils;

public class TestInjector<O> {

	/**
	 * Object containing fields to inject values into and get values from.
	 */
	private O object;
	
	/**
	 * Creates an instance of a TestInjector and assigns the containing object to act on.
	 * @param object - object containing fields to inject values into and get values from.
	 */
	public TestInjector(O object){
		this.object = object;
	}
	
	/**
	 * Returns the field of matching name in the containing object.
	 * @param fieldName - name of the field to return in the containing object
	 * @return
	 */
	public Object get(String fieldName) {
		Field field = ReflectionUtils.findField(object.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		return ReflectionUtils.getField(field, object);
	}
	
	/**
	 * Injects the private field with a name matching fieldName inside of the object.
	 * @param fieldName - name of the field in the containing object to be injected
	 * @param value - value to inject into the field of the containing object
	 */
	public void set(String fieldName, Object value) {
		Field field = ReflectionUtils.findField(object.getClass(), fieldName);
		ReflectionUtils.makeAccessible(field);
		ReflectionUtils.setField(field, object, value);
	}
	
}
