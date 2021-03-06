package com.yunpian.excle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//读取excel返回object类
public class ReadExcel {
	public static List<Map<String, String>> readXlxs(String filename){
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(filename);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//循环工作表Sheet
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		//循环行Row
		XSSFRow rowTitleRow = xssfSheet.getRow(0); //标题行
		for (int rowNum = 1;rowNum <= xssfSheet.getLastRowNum();rowNum++) {
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if (xssfRow == null) {
				continue;
			}
			
			Map<String, String> map = new HashMap<String, String>();
			//// 循环列Cell
			for (int cellNum =0; cellNum < rowTitleRow.getLastCellNum(); cellNum++) {
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				XSSFCell xssfCellTitleCell = rowTitleRow.getCell(cellNum);
				map.put(getValue(xssfCellTitleCell), getValue(xssfCell));
			}
			list.add(map);
		}		
		return list;
	}
	
	@SuppressWarnings("static-access")
	private static String getValue(XSSFCell xssfCell) {
		if (xssfCell == null) {
			return "";
		}
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfCell.getBooleanCellValue());
		}else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){
			return String.valueOf(xssfCell.getNumericCellValue());
		}else {
			return String.valueOf(xssfCell.getStringCellValue());
		}		
	}
}
