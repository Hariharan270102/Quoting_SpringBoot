package edu.capstone_project.ViewQuote.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.capstone_project.ViewQuote.model.ViewQuote;
import edu.capstone_project.ViewQuote.model.ViewQuoteExcel;
import edu.capstone_project.ViewQuote.repository.ViewQuoteRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ViewQuoteExcelReportService 
{
	private final ViewQuoteRepository quoteRepository;
	
	public void generateExcel(HttpServletResponse httpServletResponse,String user_mail) throws IOException {
		System.out.println("in xls service");
//		String mail=user_mail.substring(1, user_mail.length());
//		System.out.println(mail);
//		System.out.println(mail.length());
	
		System.out.println(user_mail);

		List<ViewQuote> quoteList= quoteRepository.findByUserEmail(user_mail);
		System.out.println(quoteList);
		List<ViewQuoteExcel> excelList=new ArrayList<>();
		int sum=0;
		for(ViewQuote i : quoteList) {
			ViewQuoteExcel quoteExcel=ViewQuoteExcel.builder().planId(i.getPlanId()).userEmail(i.getUserEmail()).userPhonenumber(i.getUserPhonenumber()).planName(i.getPlanName()).planPrice(i.getPlanPrice()).planCategory(i.getPlanCategory()).planData(i.getPlanData()).planValidity(i.getPlanValidity()).planSubscription(i.getPlanSubscription()).planLocations(i.getPlanLocations()).quantity(i.getQuantity()).build();
			excelList.add(quoteExcel);
			
		}
		
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("Quote Excel");
		
		HSSFRow row= sheet.createRow(0);
		row.createCell(0).setCellValue("PLAN NAME");
		row.createCell(1).setCellValue("PLAN DATA");
		row.createCell(2).setCellValue("PLAN VALIDITY");
		row.createCell(3).setCellValue("PLAN CATEGORY");
		row.createCell(4).setCellValue("PLAN SUBSCRIPTIONS");
		row.createCell(5).setCellValue("PLAN LOCATIONS");
		row.createCell(6).setCellValue("PLAN QUANTITY");
		row.createCell(7).setCellValue("PLAN PRICE");
		row.createCell(8).setCellValue("PLAN VALUE");

		
		
		
		int dataRowIndex=1;
		for(ViewQuoteExcel i :excelList) {
			
			HSSFRow dataRow=sheet.createRow(dataRowIndex);
			String planSubscription = String.join(", ", i.getPlanSubscription());
			String planLocations = String.join(", ", i.getPlanLocations());


			dataRow.createCell(0).setCellValue(i.getPlanName());
			dataRow.createCell(1).setCellValue(i.getPlanData());
			dataRow.createCell(2).setCellValue(i.getPlanValidity());
			dataRow.createCell(3).setCellValue(i.getPlanCategory());
			dataRow.createCell(4).setCellValue(planSubscription);
			dataRow.createCell(5).setCellValue(planLocations);
			dataRow.createCell(6).setCellValue(i.getQuantity());
			dataRow.createCell(7).setCellValue("₹"+i.getPlanPrice());
			dataRow.createCell(8).setCellValue("₹"+(i.getPlanPrice()*i.getQuantity()));
			sum=sum+(i.getPlanPrice()*i.getQuantity());
			dataRowIndex++;

		}
		System.out.println(dataRowIndex);
		HSSFRow totalRow=sheet.createRow(dataRowIndex+1);
		totalRow.createCell(0).setCellValue("TOTAL QUOTE");
		totalRow.createCell(1).setCellValue("₹"+sum);
		
		HSSFRow payableRow=sheet.createRow(dataRowIndex+3);
		payableRow.createCell(0).setCellValue("PAYABLE AMOUNT (18% tax)");
		payableRow.createCell(1).setCellValue("₹"+(sum+(0.18*sum)));

		
		

		
		
		
		ServletOutputStream outputStream= httpServletResponse.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		


	}
	

}
