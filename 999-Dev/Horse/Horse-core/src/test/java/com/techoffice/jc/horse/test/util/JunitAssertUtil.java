package com.techoffice.jc.horse.test.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;

/**
 * JUnit Assert Utility 
 * 
 * @author imben1109
 *
 */
public class JunitAssertUtil {

	private JunitAssertUtil(){
		
	}
	
	/**
	 * Assert Bean All Property Not Null
	 * 
	 * @param bean
	 */
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
