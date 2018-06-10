package net.lovememo.euler.Problem01_25;

public class Problem21 {

	public static long d(long n) {
		long sum = 1L;
		for(long i=2L; i<=Math.sqrt(n); i++) 
			if(n%i==0) {
				if(i != n/i)
					sum += (i + n/i);
				else
					sum += i;
			}
		return sum;
		 
	}
	
	public static boolean isAmicableNumber(long n,long maxNumber) {
		long num = d(n);
		if(d(num) == n && num <= 10000 && num!=n)
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long sum = 0;
		long maxNumber = 10000;
		for(long i=1; i<maxNumber+1; i++) {
			if(isAmicableNumber(i,maxNumber)) {
				sum += i;
				System.out.print(i+ " ");
			}
		}
		System.out.println();
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺 " + (endTime - startTime) + "ms.");
	}

}
