package com.taxholic.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	
	/**
	 * 엑셀 생성		
	 * @param header
	 * @param list
	 * @param respons
	 */
	public static void createExcel(String [] header, List<String[]> list, String fileName, HttpServletResponse respons) {
		
		XSSFWorkbook wb = new XSSFWorkbook();						//워크북을 생성
		XSSFSheet sheet = wb.createSheet("Sheet1");						//시트 생성
		
		//스타일
		XSSFCellStyle style = wb.createCellStyle();							
		style.setFillPattern ((short) 1);												
		style.setFillForegroundColor (HSSFColor.GOLD.index);	// 배경색 지정 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);							//정렬
		
		//헤더 생성
		XSSFRow initRow = sheet.createRow(0);			
		
		
		for(int i = 0; header !=null && i <  header.length; i++){
			//셀 너비
			 sheet.setColumnWidth(i, 4000);
			
			XSSFCell cell = initRow.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(header[i]);
		}
		
		//데이터 생성
		for(int i = 0; i < list.size(); i++){
			String [] arrData = list.get(i);
			XSSFRow row = sheet.createRow( i+1 );
			for(int j =0; arrData != null && j <arrData.length; j++){
				row.createCell(j).setCellValue(arrData[j]);
			}
		}
		
		OutputStream fileOut = null;
		
		try{	
			fileOut = respons.getOutputStream();
			
			respons.reset(); 
			respons.setContentType("application/vnd.ms-excel"); //필수 부분 --
			respons.setHeader("Content-Disposition", "attachment; filename="+fileName); //필수 부분 --
			
			wb.write(fileOut);
		}catch (Exception e){
			e.getStackTrace();
		}finally{
			if(fileOut != null)	try {fileOut.close();} catch (IOException e) {}
		}
		
	}
	
	/**
	 * 엑셀데이터 로드
	 * @param header
	 * @param pfs
	 * @return List
	 */
	public static List<Map<String,String>> getExcel(String [] header, InputStream stram) {
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		try{
			//워크북을 생성
			XSSFWorkbook wb = new XSSFWorkbook(stram);
			
			//생성된 워크북을 이용하여 시트 수만큼 돌면서 엑셀 시트 하나씩을 생성
			int sheetNum = wb.getNumberOfSheets();
			for (int k = 0; k < sheetNum; k++) {
				XSSFSheet sheet = wb.getSheetAt(k);
				
				//생성된 시트를 이용하여 그 행의 수만큼 돌면서 행을 하나씩 생성
				int rows = sheet.getPhysicalNumberOfRows();
				for (int r = 1; r < rows; r++) {
					XSSFRow row   = sheet.getRow(r);
					
					//생성된 행을 이용하여 그 셀의 수만큼 돌면서 셀을 하나씩 생성
//					int cells = row.getPhysicalNumberOfCells();
					int cells = header.length;
					Map<String,String> hm = new HashMap<String,String>();
					for (short c = 0; c < cells; c++) { 
				    	XSSFCell cell  = row.getCell(c); 
				   		if (cell != null) {
				   			hm.put(header[c], cell.toString());
				   		}
					}
					list.add(hm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
	
}
