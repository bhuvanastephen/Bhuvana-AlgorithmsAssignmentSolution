package com.greatlearning.service;

import com.greatlearning.model.StockCompany;

public class SortService {
	private float arr[];
	private String order="asc";
	float[] arrSortedAsc = null;
	float[] arrSortedDesc = null;


	public float[] SortServiceMain(StockCompany[] company, SortService sortSerObjPassed, String order, boolean printSortedValues) {
		this.order = order;
		arr = new float[company.length];
		int j = -1;

		try {
			//Do not Sort if already sorted
			if ((sortSerObjPassed !=  null) && ((sortSerObjPassed.arrSortedDesc != null)) || (sortSerObjPassed.arrSortedAsc != null)) { 
				if ((order == "asc") && (sortSerObjPassed.arrSortedAsc != null)) {
					this.arr = sortSerObjPassed.arrSortedAsc; }
				else if ((order == "des") && (sortSerObjPassed.arrSortedDesc != null)) {
					this.arr = sortSerObjPassed.arrSortedDesc; }
				else if ((order == "asc") && (sortSerObjPassed.arrSortedAsc == null) && sortSerObjPassed.arrSortedDesc != null) {
					this.arr = reverseSortOrder(sortSerObjPassed.arrSortedDesc); }
				else if ((order == "des") && (sortSerObjPassed.arrSortedDesc == null) && sortSerObjPassed.arrSortedAsc != null) {
					this.arr = reverseSortOrder(sortSerObjPassed.arrSortedAsc); }
			}else { //Merge Sort if not already sorted
				for  (StockCompany stockPrice : company ) {
					j++;
					arr[j]=stockPrice.getStockPrice();
				}		
				mergeSort(arr, 0, (company.length-1));
			}
			
			//print sorted array
			if (printSortedValues == true) {
				printArray(arr);
			}

			if (order == "asc") {arrSortedAsc = arr;
			}else { arrSortedDesc = arr; }
			return arr;
		}catch(Exception ex) {
			System.out.println("Exception in SortServiceMain" + ex.getMessage());
			return null;
		}
	}

	public float[] reverseSortOrder(float arr[]) {
		int arrLen = arr.length;
		float[] reversedArr =new float[arrLen];
		
		try {
			for(int i=0; i<arr.length; i++) {
				reversedArr[i]= arr[arrLen-1];
				arrLen --;
			}
			return reversedArr;
		}catch(Exception ex) {
			System.out.println("Exception in reversing" + ex.getMessage());
			return null;
		}
	}
	public void merge(float arr[], int left, int mid,int right) {

		//find the sizes of two sub arrays
		int n1=mid - left +1;
		int n2= right - mid;

		//create temporary arrays
		float leftarray[]= new float[n1];
		float rightarray[]= new float[n2];

		try {
			//copy data to left array
			for (int i=0; i<n1; i++) {
				leftarray[i]=arr[left+i];
			}
			//copy data to right array
			for (int i=0; i<n2; i++) {
				rightarray[i]=arr[mid +1+ i];
			}

			//merge
			int i= 0; int j=0;
			int k=left;

			while (i<n1 && j<n2) {
				if ( (order == "asc") && (leftarray[i] <= rightarray[j]) )  {//to sort in ascending-order
					arr[k]=leftarray[i];
					i++;
				}
				else if ( (order == "des") && (leftarray[i] >= rightarray[j]) )  {//to sort in descending-order
					arr[k]=leftarray[i];
					i++;
				}
				else {
					arr[k]=rightarray[j];
					j++;
				}
				k++;
			}

			while(i<n1) {
				arr[k]=leftarray[i];
				i++;
				k++;
			}

			while(i<n2) {
				arr[k]=rightarray[j];
				j++;
				k++;
			}
		}catch(Exception ex) {
			System.out.println("Exception in merging" + ex.getMessage());
		}
	}

	public void mergeSort(float arr[], int left, int right) {

		try {
			if (left<right) {//so that its not single element
				//Find middle
				int mid= (left + right )/2;

				//Sort 
				mergeSort(arr,left,mid);
				mergeSort(arr,mid+1,right);		

				//Merge
				merge(arr,left,mid,right);
			}
		}catch(Exception ex) {
			System.out.println("Exception in mergSort" + ex.getMessage());
		}
		
	}

	public void printArray(float arr[]) {
		System.out.println("----------------------");
		System.out.println("Stock prices in " + order + " order");
		for (int i=0; i< arr.length; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		System.out.println("----------------------");
		
	}
}
