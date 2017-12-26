package com.techoffice.util;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * Bean Utility
 * 
 * @author TechOffice
 *
 */
public class BeanUtil {

	private BeanUtil(){}

	/**
	 * Convert Bean to String for display
	 * 
	 * @param bean
	 * @return string in format of property name + ":" + property value 
	 */
	public static String toString(Object bean){
		String toStringResult = "";
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(bean);
		for (int i=0; i<propertyDescriptors.length; i++){
			PropertyDescriptor propertyDescriptor = propertyDescriptors[i];
			if (!"class".equals(propertyDescriptor.getName())){
				String propertyValue = "";
				try {
					propertyValue = PropertyUtils.getProperty(bean, propertyDescriptor.getName()).toString();
				} catch (Exception e) {
					propertyValue = null;
				} 
				toStringResult += propertyDescriptor.getName() + ":" + propertyValue + " ";
			}
		}
		return toStringResult;
	}
	
}
