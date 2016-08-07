package com.taxholic.core.util;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String,Object> ModelMap,HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception{

		String fileName = ModelMap.get("fileName").toString();
		HSSFSheet worksheet = null;
		HSSFRow row = null;

		fileName=URLEncoder.encode(fileName,"UTF-8");
		worksheet = workbook.createSheet("Sheet1");

		//스타일
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillPattern ((short) 1);
		style.setFillForegroundColor (HSSFColor.GREY_25_PERCENT.index);	// 배경색 지정
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);							//정렬

		String header[] = (String[]) ModelMap.get("header");
		List<String[]> list = (List)ModelMap.get("excelList");

		//////// 테스트중
		List<String[]> statsList = (List)ModelMap.get("statsList");
		for(int i = 0; statsList != null && i < statsList.size(); i++){
			String [] arrData = statsList.get(i);

			row = worksheet.createRow(i);
			int idx = 0;

			for(int j =0; arrData != null && j <arrData.length; j++){

				if(i==0 && j==1){
					worksheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
				}
				if(i==3 && j==1)
					worksheet.addMergedRegion(new CellRangeAddress(3,3,1,6));

				row.createCell(idx).setCellValue(arrData[j]);
				if(i==0 && j==1) idx++;
				idx++;
			}
		}

		int rowIdx = 0;
		if(ModelMap.get("rowIdx") != null)
			rowIdx = (Integer)ModelMap.get("rowIdx");
		////////

		//헤더 생성
		row = worksheet.createRow(rowIdx);
		for(int i = 0; header !=null && i < header.length; i++){
		    worksheet.setColumnWidth(i, 4000);
		    HSSFCell cell = row.createCell(i);
		    cell.setCellStyle(style);
		    cell.setCellValue(header[i]);
		}

		//데이터 생성
		for(int i = 0; i < list.size(); i++){
			  String [] arrData = list.get(i);
			  row = worksheet.createRow(rowIdx+(i+1));
			  for(int j =0; arrData != null && j <arrData.length; j++){
				  row.createCell(j).setCellValue(arrData[j]);
			  }
		}

		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "ATTachment; Filename="+fileName+".xls");
	}
}

