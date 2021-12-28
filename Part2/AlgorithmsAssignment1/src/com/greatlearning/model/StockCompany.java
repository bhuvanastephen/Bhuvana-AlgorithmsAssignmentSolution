package com.greatlearning.model;

import java.util.Scanner;

public class StockCompany {
	private int companyId = 0;
	private float stockPrice = 0;
	private Boolean stockRiseStatus = false;
	private static Scanner sc = new Scanner(System.in);

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Boolean getStockRiseStatus() {
		return stockRiseStatus;
	}

	public void setStockRiseStatus(Boolean stockRiseStatus) {
		this.stockRiseStatus = stockRiseStatus;
	}


	public void addCompanyDetails(int companyId ) {
		Boolean inputCorrectFormat = true;
		companyId = companyId + 1;
		do {
			try {
				this.companyId = companyId;
				System.out.println("Enter current stock price of the company " + companyId);
				this.stockPrice = sc.nextFloat();
				System.out.println("Whether company's stock price rose today compare to yesterday?");
				this.stockRiseStatus = sc.nextBoolean();
				inputCorrectFormat = true;
			}catch(Exception ex) {
				System.out.println("Invalid input format, please input again ");
				inputCorrectFormat = false;
				sc =new Scanner(System.in);
			}
		}while(inputCorrectFormat == false);
	}

	public static void printCompanyDetails(StockCompany[] companyArrayObj ) {

		System.out.println("---------Company Stock details----------");
		System.out.print("Company ID\t");
		System.out.print("Stock Price\t");
		System.out.print("Status\n");
		for  (StockCompany company : companyArrayObj ) {
			System.out.print(company.getCompanyId() + "\t\t");
			System.out.print(company.getStockPrice() + "\t\t");
			System.out.print(company.getStockRiseStatus() + "\n");
		}
		System.out.println("----------------------------------------");
	}

}
