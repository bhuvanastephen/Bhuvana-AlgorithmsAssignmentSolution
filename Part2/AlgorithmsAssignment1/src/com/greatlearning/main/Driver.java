package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.model.StockCompany;
import com.greatlearning.service.*;


public class Driver {

	private static Scanner sc =new Scanner(System.in);
	private static StockCompany[] company = null;
	private static SortService sortSerObj = null;
	private static AnalyseService analyseObj = null;
	private static SearchService searchObj = null;
	
	public static void main(String[] args) {
		int noOfCompany = 0;
		float searchValue = 0;
		int operation = 0;
		
		try {
			//Get number of companies
			System.out.println("Enter the no of companies");
			noOfCompany= sc.nextInt();
			company= new StockCompany[noOfCompany];
			
			//Add Stock company details
			for (int i=0;i<noOfCompany;i++) {
				company[i]=new StockCompany();
				company[i].addCompanyDetails(i);
			}
			
			//Print Company Stock De
			StockCompany.printCompanyDetails(company);
			
			do {
				//Display Operations
				operation= displayOptions();
				switch(operation) {
				case 1:
					//Sort Stock in Ascending order
					if (sortSerObj == null){sortSerObj= new SortService();}
					sortSerObj.SortServiceMain(company, sortSerObj, "asc", true);
					break;
				case 2:
					//Sort Stock in Descending order
					if (sortSerObj == null){sortSerObj= new SortService();}
					sortSerObj.SortServiceMain(company, sortSerObj, "des", true);
					break;
				case 3:
					//Count of companies Stock price rose
					if (analyseObj == null){analyseObj= new AnalyseService();}
					analyseObj.stockPriceAnalysis(company, "stock-rise");
					break;
				case 4:
					//Count of companies Stock price fallen
					if (analyseObj == null){analyseObj= new AnalyseService();}
					analyseObj.stockPriceAnalysis(company, "stock-fallen");
					break;
				case 5:
					//Search for specific stock price
					System.out.println("Enter the key value");
					searchValue= sc.nextFloat();
					if (searchObj == null){searchObj= new SearchService(company,sortSerObj);}
					searchObj.searchValue(searchValue);
					break;
				case 0:
					//Exit
					System.out.println("Exited successfully");
					System.out.println("Happy Stocking !!!");
					break;
				default:
					//Invalid Option
					System.out.println("Invalid option-- Press 0 to exit");
					break;
				}
			}while (operation != 0);
		}catch(Exception ex ){
			System.out.println("Exception" + ex.getMessage());
		}
		
	}
	
	public static int displayOptions() {
		
		int choice = 0;
		
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. Press 0 to exit");
		try {
			choice=sc.nextInt();
		}
		catch(Exception ex){
			System.out.println("Invalid choice " + ex.getMessage());
		}
		
		return choice;
	}

}
