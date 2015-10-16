package Problem01_25;

import java.math.BigInteger;

public class Problem25 {
	public static BigInteger[] cacheTable = new BigInteger[5000];
	static {
		for(int i=0; i<5000; i++) {
			cacheTable[i] = BigInteger.ZERO;
		}		
	}
	
	public static int getDigits(BigInteger num) {
		return num.toString().length();
	}
	
	public static BigInteger getFibonacciNumber(int i) {
		if(i==1 || i==2)
			return BigInteger.ONE;
		
		BigInteger tmp1 = null;
		if(cacheTable[i-1].compareTo(BigInteger.ZERO) == 0) {
			tmp1 = getFibonacciNumber(i - 1);
			cacheTable[i-1] = tmp1;
		}
		else
			tmp1 = cacheTable[i-1];
		
		BigInteger tmp2 = null;
		if(cacheTable[i-2].compareTo(BigInteger.ZERO) == 0) {
			tmp2 = getFibonacciNumber(i - 2);
			cacheTable[i-2] = tmp2;
		}
		else
			tmp2 = cacheTable[i-2];
		
		return tmp1.add(tmp2);
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i=1; i<5000; i++) {
			BigInteger num = getFibonacciNumber(i);
			if(getDigits(num)>=1000) {
				System.out.println(i + " " + num);
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("ÏûºÄÊ±¼ä£º " + (endTime - startTime) + "ms.");	

	}

}
