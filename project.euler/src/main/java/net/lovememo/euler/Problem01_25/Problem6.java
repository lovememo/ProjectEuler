package net.lovememo.euler.Problem01_25;

public class Problem6 {
	public static void main(String[] args) {
		int num = 100;
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=1; i<=num; i++) {
			sum1 += i*i;
		}
		
		for(int i=1; i<=num; i++) {
			sum2 += i;
		}
		sum2 *= sum2;
		
		System.out.println(sum2 - sum1);
	}

}
