package com.wsl.Sort;

public class XuanZeSort {
	public static  Integer[] xuanZe(Integer[] arr) {
		
		for(Integer i = 0 ; i < arr.length - 1 ; i++) {
			Integer minIndex=i;
			
			for(Integer j = i + 1 ; j < arr.length ; j++) {
				
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				
			}
			
			 if(i!=minIndex)
		        {
		            Integer temp=arr[i];
		            arr[i]=arr[minIndex];
		            arr[minIndex]=temp;
		        }
		}
		
		return arr;
	}
}
