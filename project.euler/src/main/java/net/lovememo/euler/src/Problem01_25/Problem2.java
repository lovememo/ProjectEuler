package Problem01_25;

public class Problem2 {

	private static long getFibonacci(int i) {
		if(i == 0)
			return 1L;
		if(i == 1)
			return 2L;
		return getFibonacci(i-1) + getFibonacci(i-2);
		
	}
	public static void main(String[] args) {
		int i=0;
		long fibonacciNum;
		long sum = 0;
		while((fibonacciNum=getFibonacci(i))<4000000L) {
			if (fibonacciNum%2==0)
				sum += fibonacciNum;
			i ++;
		}
		System.out.println(sum);

	}

}
