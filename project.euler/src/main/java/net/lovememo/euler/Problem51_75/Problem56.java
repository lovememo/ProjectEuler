package net.lovememo.euler.Problem51_75;

import net.lovememo.euler.util.EulerUtil;

/**
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 
 * 100^100 is almost unimaginably large: one followed by two-hundred zeros. 
 * Despite their size, the sum of the digits in each number is only 1.
 * Considering natural numbers of the form, a^b, where a, b<100, what is the maximum digital sum?
 * */
public class Problem56 {	
	
	
	
	public static void showNum(Integer[] num) {
		for(int i=num.length-1; i>=0; i--) {
			System.out.print(num[i]);
		}
		System.out.println();
	}
	
	public static int getDigitsSum(Integer[] num) {
		int sum = 0;
		for(int i=0; i<num.length; i++) {
			sum += num[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		//showNum(EulerUtil.getPower(56, 723));
		long s = System.currentTimeMillis();
		int max = 0;
		for(int i=1; i<=99; i++) {
			for(int j=1; j<=99; j++) {
				int tmp = getDigitsSum(EulerUtil.getPower(i, j));
				max = tmp > max ? tmp : max;
			}
		}
		System.out.println(max);
		long e = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(e-s) + " ms");
	}

}
