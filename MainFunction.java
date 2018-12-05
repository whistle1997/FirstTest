package com.wsl.Sort;

public class MainFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {12,45,11,65,32};
		//Integer[] maoPao = MaoPaoSort.MaoPao(arr);
		Integer[] xuanZe = XuanZeSort.xuanZe(arr);
		for (Integer i : xuanZe) {
			System.out.println(i+" ");
		}
		
	}

}
