package com.techoffice.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

import com.techoffice.jc.horse.dto.CurrentOdd;

public class BeanUtil {

	private BeanUtil(){}

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
