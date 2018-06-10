package net.lovememo.euler.Problem26_50;

import java.util.HashMap;


public class Problem32 {
	
	private int[] array = new int[9];
	private int sum = 0;
	private HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();

	/**whether array is one of the right solution*/
	private void isPandigitalProducts() {
		int length = array.length;
		for(int flag1=0; flag1<=length/2; flag1++) {
			for(int flag2=flag1+1; flag2<=length/2+1; flag2++) {
				int a = getNumber(0, flag1);
				int b = getNumber(flag1+1, flag2);
				int c = getNumber(flag2+1, length-1);
				if(a*b == c) {
					//System.out.println(a + " * " + b  + " = " + c);
					if(hm.get(c) == null) {
						hm.put(c, c);
						sum += c;
					}
				}
			}
		}		
	}
	
	/**transform array into number*/
	private int getNumber(int start, int end) {
		int number = 0;
		int base = 1;
		int length = end - start + 1;
		for(int i=0; i<length-1; i++) {
			base *= 10;
		}
		for(int i=start; i<=end; i++) {
			number += array[i] * base;
			base /= 10;
		}
		return number;
	}
	
	public void getSolution() {
		this.getPermutation(9);
	}
	
	/**get permutation of array which contains numbers from 1~9*/
	private void getPermutation(int number) {
		int length = array.length;
		if(number == 1) {
			int[] mark = new int[length+1];
			for(int i=0; i<=length-number-1; i++) {
				int value = array[i];
				mark[value] = 1;
			}
			for(int i=1; i<=length; i++) {
				if(mark[i] == 1)
					continue;
				array[length-1] = i;
			}
			//showPermutation();
			isPandigitalProducts();
			return;
		}
		int[] mark = new int[length+1];
		for(int i=0; i<=length-number-1; i++) {
			int value = array[i];
			mark[value] = 1;			
		}
		for(int i=1; i<=length; i++) {
			if(mark[i] == 1)
				continue;
			array[length-number] = i;
			getPermutation(number - 1);
		}
		
	}
	
/*	private void showPermutation() {
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]);
		System.out.println();
	}*/
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		Problem32 problem = new Problem32();		
		problem.getSolution();
		System.out.println(problem.sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endTime - startTime) + "ms");
		
	}

}
