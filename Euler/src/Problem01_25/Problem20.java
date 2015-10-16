package Problem01_25;

public class Problem20 {

	public static void main(String[] args) {
		int length = 1000;
		int [] result = new int[length];
		result[0] = 1;
		
		int n = 100;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<length; j++) {
				result[j] *= i+1;
			}
			for(int j=0; j<length; j++) {
				if(result[j] > 9) {
					result[j+1] += result[j]/10;
					result[j] -= result[j]/10*10;
					
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<length; i++) {
			sum += result[i];
		}
		System.out.println(sum);

	}

}
