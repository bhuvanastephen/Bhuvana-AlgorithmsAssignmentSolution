package com.greatlearning.service;
import com.greatlearning.model.StockCompany;

public class AnalyseService {
	private String companyId = "";
	
	public void stockPriceAnalysis(StockCompany[] company, String status) {
		int count = 0;
		companyId = ""; //to store company Id rose or fallen
		
		for  (StockCompany stockPrice : company ) {
			if ((status == "stock-rise") && (stockPrice.getStockRiseStatus() == true)){
				count++;
				companyId  +=  " " + stockPrice.getCompanyId();
			}
			else if ((status == "stock-fallen") && (stockPrice.getStockRiseStatus() == false)){
				count++;
				companyId  += " " + stockPrice.getCompanyId();
			}
		}
		printAnalysis(status,count);
	}
	
	public void printAnalysis(String status, int noOfCompanies) {
		System.out.println("-----------------------------------------------------------");
		if (status == "stock-rise") {
			System.out.println("Total no of companies whose stock price rose today :" + noOfCompanies);
		}
		else if (status == "stock-fallen") {
			System.out.println("Total no of companies whose stock price declined today : " + noOfCompanies);
		}
		System.out.println("Company Id's are:" + companyId);
		System.out.println("-----------------------------------------------------------");
	}				
}
