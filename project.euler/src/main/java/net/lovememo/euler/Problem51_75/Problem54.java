package net.lovememo.euler.Problem51_75;

import net.lovememo.euler.util.EulerUtil;

/**
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 * Not all numbers produce palindromes so quickly. For example,
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 * That is, 349 took three iterations to arrive at a palindrome.
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome. 
 * A number that never forms a palindrome through the reverse and add process is called a Lychrel number. 
 * Due to the theoretical nature of these numbers, and for the purpose of this problem, 
 * we shall assume that a number is Lychrel until proven otherwise. In addition you are given 
 * that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations, 
 * or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome. 
 * In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome: 
 * 4668731596684224866951378664 (53 iterations, 28-digits).
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 * How many Lychrel numbers are there below ten-thousand?
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
 *
 */
public class Problem54 {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		int count = 0;
		for(int i=1; i<10000; i++) {
			if(isLychrel(i)) {
				count ++;
			}
		}
		System.out.println(count);
		long e = System.currentTimeMillis();
		System.out.println("Time used:" + (e-s) + "ms");
		
	}
	
	public static boolean isLychrel(int num) {
		Integer[] srcNum = EulerUtil.number2Array(num);
		Integer[] revNum;
		for(int i=0; i<50; i++) {
			revNum = EulerUtil.reverseNum(srcNum);
			srcNum = EulerUtil.numberAddNumber(srcNum, revNum);
			if(isPalindrome(srcNum)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public static boolean isPalindrome(Integer[] num) {
		int max = num.length - 1;
		int min = 0;
		int mid = (max - min) / 2;
		
		for(int i=0; i<=mid; i++) {
			if(num[i] != num[max-i])
				return false;
		}
		return true;
	}
	
	
	
	public static String getNumStr (Integer[] num) {
		String str = "";
		for(int i=num.length-1; i>=0; i--) {
			str += num[i];
		}
		return str;
	}
	
	public static void showNum(Integer[] num) {
		for(int i=num.length-1; i>=0; i--) {
			System.out.print(num[i]);
		}
		System.out.println();
	}
	
	
	
	public static void executeAddTestCases() {
		System.out.println("=====case1=====");
		Integer[] arr1 = EulerUtil.number2Array(1);
		Integer[] arr2 = EulerUtil.number2Array(2);
		Integer[] res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		
		System.out.println("=====case2=====");
		arr1 = EulerUtil.number2Array(9);
		arr2 = EulerUtil.number2Array(1);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case3=====");
		arr1 = EulerUtil.number2Array(9);
		arr2 = EulerUtil.number2Array(4);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case4=====");
		arr1 = EulerUtil.number2Array(12);
		arr2 = EulerUtil.number2Array(4);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case5=====");
		arr1 = EulerUtil.number2Array(55);
		arr2 = EulerUtil.number2Array(55);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);		
		System.out.println("=====case6=====");
		arr1 = EulerUtil.number2Array(12);
		arr2 = EulerUtil.number2Array(9);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case7=====");
		arr1 = EulerUtil.number2Array(12);
		arr2 = EulerUtil.number2Array(8);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case8=====");
		arr1 = EulerUtil.number2Array(9999);
		arr2 = EulerUtil.number2Array(1);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case9=====");
		arr1 = EulerUtil.number2Array(2222222);
		arr2 = EulerUtil.number2Array(222222222);
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
		System.out.println("=====case10=====");
		arr1 = new Integer[]{1,2,4,5,3,2,3,4,5,3,4,3,2,1,1,2,3,4,5,6,7,4};
		arr2 = new Integer[]{1,9,7,5,4,2,4,5,6,3,5,6,7,8,6,4,3,2,4,3,9,9,3,2,1,1,3,3,7};
		res = EulerUtil.numberAddNumber(arr1, arr2);
		showNum(arr1);
		showNum(arr2);
		showNum(res);
	}
}
