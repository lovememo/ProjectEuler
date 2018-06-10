package net.lovememo.euler.Problem01_25;
//see more efficient solution in Abundant.java

public class Problem23 {
	public static int[] isAbundantNumberCache = new int[30000];
	
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
	
	public static boolean isAbundantNumber(int n) {
		if(isAbundantNumberCache[n] == 1)
			return true;
		if(isAbundantNumberCache[n] == -1)
			return false;
		
		if(d(n)>n) {
			isAbundantNumberCache[n] = 1;
			return true;
		} else {
			isAbundantNumberCache[n] = -1;
			return false;
		}
	}
	
	public static boolean isNonAbundantSum(int n) {
		for(int i=1; i<=n/2; i++) 
			if(isAbundantNumber(i) && isAbundantNumber(n-i)) 
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		long fakeUpperLimit = 28123L;
		long sum = 0L;
		for(int i=1; i<=fakeUpperLimit; i++) {
			if(isNonAbundantSum(i))
				sum += i;
		}
		System.out.println(sum);		   
		
		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺 " + (endTime - startTime) + "ms.");
		

	}

}
