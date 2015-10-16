package Problem01_25;

public class Problem3 {
	private static long getLagestPrimeFactor(long num) {
		for(long i=2; i<num; i++) {
			if(num%i == 0) {
				return getLagestPrimeFactor(num/i);
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		long num = 600851475143L;
		System.out.println(getLagestPrimeFactor(num));

	}

}
