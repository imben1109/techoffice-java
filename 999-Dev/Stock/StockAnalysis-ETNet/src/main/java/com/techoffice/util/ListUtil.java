package com.techoffice.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.techoffice.util.exception.ListUtilAttributeException;
import com.techoffice.util.exception.ListUtilInstatiationException;

public class ListUtil {

	private ListUtil(){}
	
	public static List<String> getAttributeList(List<?> list, String attribute){
		List<String> attributeList = new ArrayList<String>();
		for (Object obj: list){
			try {
				String attributeValue = BeanUtils.getProperty(obj, attribute);
				attributeList.add(attributeValue);
			} catch (Exception e) {
				throw new ListUtilAttributeException(e);
			}
		}
		return attributeList;	
	}
	
	public static <Orig, Dest> List<Dest> copy(List<Orig> origlist, Class<Dest> clz){
		List<Dest> destList = new ArrayList<Dest>();
		try{
			for (Orig orig: origlist){
				Dest dest = clz.newInstance();
				BeanUtils.copyProperties(dest, orig);
				destList.add(dest);
			}
		}catch(Exception e){
			throw new ListUtilInstatiationException(e);
		}
		return destList;
	}
}
