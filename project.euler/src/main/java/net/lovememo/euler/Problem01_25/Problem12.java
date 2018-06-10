package net.lovememo.euler.Problem01_25;

import java.util.ArrayList;

/**
 * @author Lovememo
 *<p>Highly divisible triangular number</p>
 *<p>http://projecteuler.net/problem=12</p>
 */
public class Problem12 {
	public static ArrayList<Long> triangularNumList = new ArrayList<Long>();
	public static int getDivisorNum(long number) {
		int sum = 0;
		long middleNum = (long) Math.sqrt(number);
		for(long i=2; i<=middleNum; i++) {
			if(number%i == 0L)
				sum += 2;
		}
		return sum + 2;
	}
	
	public static long getTriangularNum(long seq) {
		return seq * (1+seq)/2;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int i=0;
		while(true) {
			i ++;
			if(500 <= getDivisorNum(getTriangularNum(i)))
					break;
		}
		System.out.println("����Ϊ��" + getTriangularNum(i) + ", ���ĳ�������Ϊ��" + getDivisorNum(getTriangularNum(i)));
		
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endTime - startTime) + "ms");
		
	}

}
