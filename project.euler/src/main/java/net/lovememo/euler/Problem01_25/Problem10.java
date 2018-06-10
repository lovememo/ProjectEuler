package net.lovememo.euler.Problem01_25;

public class Problem10 {
	private static int[] primeArr = new int[50000000];
	private static int curPos = -1;
	private static long sum = 0;
	private static boolean isPrime(int num) {
		int sqrtNum = (int) Math.sqrt(num);
		for(int i=0; i<=curPos; i++) {
			int prime = primeArr[i];
			if(num%prime == 0)
				return false;
			if(prime > sqrtNum)
				break;
		}
		primeArr[++ curPos] = num;
		
		sum += num;
		return true;
	}
	
	public static void main(String[] args) {
//		int num = 2000000;
		int num = 987654321;
		
		long startTime = System.currentTimeMillis();
		isPrime(2);
		for(int i=3; i<num; i=i+2) {
			isPrime(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
	}
}


