package net.lovememo.euler.Problem26_50;

import java.util.ArrayList;
import java.util.Iterator;

import net.lovememo.euler.util.EulerUtil;

public class Problem35 {

	private static int getDigitNum(int number) {
		if(number == 0) 
			return 1;
		int digitNum = 0;
		while(number != 0) {
			number /= 10;
			digitNum ++;
		}
		return digitNum;
	}

	/**
	 *����һ������λ��ֵ������������
	 * */
	private static int[] getDigits(int number) {
		int digitNumber = getDigitNum(number);
		int[] digits = new int[digitNumber];
		
		for(int i=0; i<digitNumber; i++) {
			digits[i] = number - number/10*10;
			number /= 10;
		}
		
		return digits;
	}
	
	private static boolean isCircularPrime(int number) {
		int digits[] = getDigits(number);
		ArrayList<int[]> seriesOfDigits = getSeriesOfDitits(digits);
		Iterator<int[]> it= seriesOfDigits.iterator();
		while(it.hasNext()) {
			int[] tmpDigits = it.next();
			int tmpNum = (int)arrayToNumber(tmpDigits);
			if(!EulerUtil.isPrime(tmpNum))
				return false;
		}
		return true;
	}
	
	private static ArrayList<int[]> getSeriesOfDitits(int[] digits) {
		ArrayList<int[]> seriesOfDigits = new ArrayList<int[]>();
		seriesOfDigits.add(digits);
		for(int i=0; i<digits.length-1; i++) {
			int[] tmpDigits = new int[digits.length];
			for(int j=0; j<tmpDigits.length; j++) {
				tmpDigits[j] = digits[(j+i+1)%digits.length];
			}
			seriesOfDigits.add(tmpDigits);
		}		
		return seriesOfDigits;
	}

	private static long arrayToNumber(int[] arr) {
		long retNum = 0;		
		for(int i=0; i<arr.length; i++) {
			retNum += (long)arr[i] * (long)getTenDigits(i);
		}
		return retNum;
	}	
	/**
	 * ��count+1λ�ϵĻ�ֵ
	 * */
	private static int getTenDigits(int count) {
		int retNum = 1;
		for(int i=0; i<count; i++) {
			retNum *= 10;
		}
		return retNum;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {		
		long startTime = System.currentTimeMillis();		
		EulerUtil.getPrimesBelow(1000000);		
		ArrayList<Integer> primeList = (ArrayList<Integer>) EulerUtil.getPrimeList().clone();		
		Iterator<Integer> it= primeList.iterator();
		while(it.hasNext()) {			
			int number = it.next();			
			if(!isCircularPrime(number)) //�������ѭ������
				it.remove();
		}
		System.out.println("size: "+primeList.size());			
		
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");

	}

}
