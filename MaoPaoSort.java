package com.wsl.Sort;

public class MaoPaoSort {
	
	public static Integer[] MaoPao(Integer[] arr) {
		//ѭ������
		for(Integer i = 0 ; i < arr.length-1; i++) {
			//ÿһ��ѭ�����򼸴�
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
