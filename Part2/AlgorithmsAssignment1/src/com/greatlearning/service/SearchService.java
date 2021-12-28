package com.greatlearning.service;

import com.greatlearning.model.StockCompany;

public class SearchService {

	private float arr[] = null;
	
	public SearchService(StockCompany[] company, SortService sortServObjPassed ) {
		
		if ((sortServObjPassed !=  null) && (sortServObjPassed.arrSortedAsc != null))  {
			this.arr = sortServObjPassed.arrSortedAsc;
		}else { //Merge Sort if not already sorted in asc
			sortServObjPassed= new SortService();
			this.arr = sortServObjPassed.SortServiceMain(company, sortServObjPassed, "asc", false);
		}
	}
	
	public void searchValue(float searchValue) {
		System.out.println("----------------------");
		//Binary Search using sorted array
		if ((doBinarySearch(arr,searchValue)) == true) {
			System.out.println("Stock of value " + searchValue + " is present");
		}else {
			System.out.println("Stock of Value " + searchValue + " not found");
		}
		System.out.println("----------------------");
	}
	
	public boolean doBinarySearch(float[] array, float searchValue) {

		boolean result = false;
		int start = 0;
		try {
			int end = array.length -1;
			int mid = (start + end ) / 2;
			int j = 0;
			
			while(start <= end) {
				j++;
				if (searchValue < array[mid]) {
					end= mid-1 ;
				}
				else if(searchValue > array[mid]){
					start = mid +1;
				}
				else if(searchValue == array[mid]){
					result=true;
					break;
				}
				mid= (end + (start ))/2;
			}
		}catch(Exception ex){
			System.out.println("Exception in binary search"  + ex.getMessage());
		}
		return result;
	}
}
