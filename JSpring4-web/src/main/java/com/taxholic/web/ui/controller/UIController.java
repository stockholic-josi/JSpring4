package com.taxholic.web.ui.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/ui/*")
public class UIController{
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String login() {
		 return  "manager:ui/form";
	} 
	
	@RequestMapping(value = "excel", method = RequestMethod.GET)
	public String excel(Map<String,Object> ModelMap) {
		
		
		List<String[]> excelList =  new ArrayList<String[]>();

		String[] header = {"이름","제목"};
	
		for(int i = 0; i < 10; i++){

			int k = 0;
			String [] rowData = new String[header.length];

			rowData[k++] = "이름";
			rowData[k++] = "제목";
				
			excelList.add(rowData);
		}	
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		ModelMap.put("fileName", "샘플_"+sdf.format(date));
		ModelMap.put("header", header);
		ModelMap.put("excelList", excelList);

		return "excelView";
		
	} 
	
	
}