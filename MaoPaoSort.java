package com.wsl.Sort;

public class MaoPaoSort {
	
	public static Integer[] MaoPao(Integer[] arr) {
		//循环趟数
		for(Integer i = 0 ; i < arr.length-1; i++) {
			//每一趟循环排序几次
			for(Integer j = 0 ; j < arr.length-1-i ; j++) {
				
				if(arr[j] > arr[j + 1]) {
					
					Integer temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
				}
				
			}
			
		}
		
		return arr;
	}
	
}
