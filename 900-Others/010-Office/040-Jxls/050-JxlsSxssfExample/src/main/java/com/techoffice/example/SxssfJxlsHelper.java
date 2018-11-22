package com.techoffice.example;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.AreaRef;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;

/**
 * Sxssf Jxls Helepr
 * 
 * It is used for large data set.
 * 
 * @author Ben Cheng
 *
 */
public class SxssfJxlsHelper {
	
	private static String getSheetCellName(AreaRef areaRef){
		return areaRef.getFirstCellRef().getCellName().substring(areaRef.getSheetName().length() + 1);
	}
	
	public static void processTemplate(InputStream templateStream, OutputStream targetStream, Context context) throws SxssfJxlsHelperException{
		Map<String, String> xlsAreaSheetMap = new HashMap<String, String>();
		try{
			Workbook workbook = WorkbookFactory.create(templateStream);	
			PoiTransformer poiTransformer = PoiTransformer.createSxssfTransformer(workbook, 100, false);
		    AreaBuilder areaBuilder = new XlsCommentAreaBuilder();
		    areaBuilder.setTransformer(poiTransformer);
	        List<Area> xlsAreaList = areaBuilder.build();
	        for (Area xlsArea : xlsAreaList) {
	        	String tempWorkSheetName = "TEMP_" + xlsArea.getAreaRef().getSheetName();
	        	xlsAreaSheetMap.put(xlsArea.getAreaRef().getSheetName(), tempWorkSheetName);
	            xlsArea.applyAt(new CellRef(tempWorkSheetName + "!" + getSheetCellName(xlsArea.getAreaRef())), context);
	        }
	        for (String templateSheetName : xlsAreaSheetMap.keySet()){
	        	int originalSheetOrder = workbook.getSheetIndex(templateSheetName);
	        	workbook.removeSheetAt(originalSheetOrder);
	        	workbook.setSheetName(workbook.getSheetIndex(xlsAreaSheetMap.get(templateSheetName)), templateSheetName);
	        	workbook.setSheetOrder(templateSheetName, originalSheetOrder);
	        }
	        workbook.setActiveSheet(0);
	        poiTransformer.setOutputStream(targetStream);
	        poiTransformer.write();
		}catch (Exception e){
			throw new SxssfJxlsHelperException("Failed to Process Excel Report", e);
		}
	}
	
	public static class SxssfJxlsHelperException extends Exception{

		private static final long serialVersionUID = 1L;

		public SxssfJxlsHelperException(String string) {
			super(string);
		}
		
		public SxssfJxlsHelperException(String string, Throwable t) {
			super(string, t);
		}
	}
	
}
