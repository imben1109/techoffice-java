package com.techoffice.util;

/**
 * Special String Utility 
 * 
 * @author TechOffice
 *
 */
public class SpecialStringUtil {
	
	private SpecialStringUtil(){}
	
	/**
	 * Remove Special Character 
	 * 
	 * 	- Remove Question Mark (?)
	 * 	- Replace New Line to Space (\n)
	 * 	- Replace Double Space (  ) to Single Spalce ( )
	 *  - Remove Quotation Mark (’)
	 * 
	 * @param str
	 * @return 
	 */
	public static String removeSpecialCharacter(String str){
		String newStr = removeQuestionMark(str);
		newStr = replaceNewLineToSpace(newStr);
		newStr = replaceDoubleSpaceToSingleSpace(newStr);
		newStr = removeQuotationMark(newStr);
		return newStr;
	}
	
	/**
	 * Replace Double Space (  ) to Single Spalce ( )
	 * @param str
	 * @return
	 */
	public static String replaceDoubleSpaceToSingleSpace(String str){
		String newStr = str.replace("  ", " ");
		if (newStr.contains("  ")){
			newStr = replaceDoubleSpaceToSingleSpace(newStr);
		}
		return newStr;
	}
	
	/**
	 * Replace New Line (\n) to Space
	 * @param str
	 * @return
	 */
	public static String replaceNewLineToSpace(String str){
		String newStr = str.replace("\n", " ");
		return newStr;
	}
	
	/**
	 * Remove Question Mark (?)
	 * 
	 * @param str
	 * @return
	 */
	public static String removeQuestionMark(String str){
		String newStr = str.replace("?", " ");
		return newStr;
	}
	
	/**
	 * Remove Quotation Mark (’)
	 * 
	 * @param str
	 * @return str which removed Quotation Mark (’)
	 */
	public static String removeQuotationMark(String str){
		String newStr = str.replace("’", " ");
		return newStr;
	}
	
}
