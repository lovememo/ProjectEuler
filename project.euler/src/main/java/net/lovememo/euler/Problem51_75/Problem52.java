package net.lovememo.euler.Problem51_75;

import java.util.Arrays;

/**
 * 
 * @author kfzx-jinjf
 *
 *It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, 
 *but in a different order. Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, 
 *contain the same digits.
 */
public class Problem52 {
	/*
	 * ���룺num counts
	 * ����� {num, num*2, num*3, ... , num*counts}
	 * */
	public static int[] getNums(int initNum, int counts) {
		int[] retArr = new int[counts];
		for(int i=1; i<=retArr.length; i++) {
			retArr[i-1] = i * initNum;
		}
		return retArr;
	}
	
	/*
	 * ����: {1234, 2341, 2134, 2143 }
	 * ����� true
	 * ���룺 {1234, 2341, 8765, 2143}
	 * ���: false
	 */
	public static boolean hasSameDigits(int[] nums) {
		int[] initArr = getDigits(nums[0]);
		for(int i=1; i<nums.length; i++) {
			int[] cmpArr = getDigits(nums[i]);
			if(!Arrays.equals(initArr, cmpArr))
				return false;
		}
		return true;
	}
	
	/*
	 * ���룺 78651
	 * �����{1, 5, 6, 7, 8}
	 * */
	private static int[] getDigits(int num) {
		int len = 0;
		int srcNum = num;
		while(srcNum != 0) {
			len ++;
			srcNum /= 10;
		}
		int retArr[] = new int[len];
		
		srcNum = num;
		for(int i=0; i<len; i++) {
			retArr[i] = srcNum - srcNum / 10 * 10;
			srcNum /= 10;
		}
		Arrays.sort(retArr);
		return retArr;
	}
	
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		int counts = 6;
		
		for(int i=1; i<9999999; i++) {
			if(hasSameDigits(getNums(i,counts))) {
				for(int j=1; j<=counts; j++) {
					System.out.println(j * i);
				}
				break;
			}
		}
		long e = System.currentTimeMillis();
		System.out.println("Time used: " + (e-s) + " ms");
	}
}
