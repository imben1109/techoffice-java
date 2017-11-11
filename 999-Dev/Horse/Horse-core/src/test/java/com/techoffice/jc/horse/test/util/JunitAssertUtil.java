package com.techoffice.jc.horse.test.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;


public class JunitAssertUtil {

	private JunitAssertUtil(){
		
	}
	
	public static void assertAllPropertyNotNull(Object bean){
		Assert.assertNotNull(bean);
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(bean);
		for (int i=0; i<propertyDescriptors.length; i++){
			PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
			if (!"class".equals(propertyDescriptor.getName())){
				Object value = null;
				try {
					 value = PropertyUtils.getProperty(bean, propertyDescriptor.getName());
				} catch (Exception e) {
					value = null;
				}
				Assert.assertNotNull(propertyDescriptor.getName(), value);
			}
		}
	}
}
