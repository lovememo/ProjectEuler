package net.lovememo.euler.Problem26_50;


public class Problem27 {
	public static long[] cache = new long[10000000];
	
	public static boolean isPrime(int num) {
		if(num==1)
			return false;
		if(num==2)
			return true;
		if(cache[num]==1)
			return true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0)
				return false;			
		}		
		cache[num] = 1;
		return true;
	}

	public static void main(String[] args) {
		int number = 1000;
		int start = 0 - number;
		int end = number;
		int n;
		int maxN = 0;
		int resultA = 0;
		int resultB = 0;
		long startTime = System.currentTimeMillis();
		
		
		for(int a=start; a<end; a++) {
			for(int b=start; b<end; b++) {
				n = 0;
				boolean flag = false;
				if(n*n+a*n+b>0 ) {
					if(isPrime(n*n+a*n+b))
						flag = true;
				}
				while(n*n+a*n+b>0) {
					if(isPrime(n*n+a*n+b))
						n ++;
					else 
						break;
				}
				if(flag && n>maxN) {
					maxN = n;
					resultA = a;
					resultB = b;
					
				}
			}
		}
		
		System.out.println(resultA + " " + resultB + " " + maxN + " result: " + (resultA*resultB));
		
	
		
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");

	}

}
// n2 - 100n + 1
