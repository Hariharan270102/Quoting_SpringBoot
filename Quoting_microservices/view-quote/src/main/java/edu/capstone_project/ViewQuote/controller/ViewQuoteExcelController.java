package edu.capstone_project.ViewQuote.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.capstone_project.ViewQuote.service.ViewQuoteExcelReportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/generate-excel")
public class ViewQuoteExcelController {
	@Autowired
	private ViewQuoteExcelReportService excelReportService;

	@GetMapping()
	@CrossOrigin(origins = "http://localhost:4200")
	public void generateExcelReport(HttpServletResponse httpServletResponse,@RequestParam String user_mail) throws IOException {
		System.out.println("in xls controller");
		String hi="hi";
		System.out.println(hi);
		httpServletResponse.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition"; 
		
		String headerValue="attachement;filename=quote_invoice.xls";
		
		httpServletResponse.setHeader(headerKey, headerValue);
		
		excelReportService.generateExcel(httpServletResponse,user_mail);
	}
}
