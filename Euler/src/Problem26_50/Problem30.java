package Problem26_50;

public class Problem30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		for(int a=0; a<=9; a++)
			for(int i=0; i<=9; i++) 
				for(int j=0; j<=9; j++)
					for(int k=0; k<=9; k++) 
						for(int m=0; m<=9; m++) 
							for(int n=0; n<=9; n++) {
								int num1 = a*100000+i*10000+j*1000+k*100+m*10+n;
								int num2 = (int)(Math.pow(a, 5)+Math.pow(i, 5)+Math.pow(j, 5)+Math.pow(k, 5)+Math.pow(m, 5)+Math.pow(n, 5));
								if(num1 == num2) {
									System.out.println(num1);
									sum += num1;
								}
							}
		System.out.println(sum-1);

	}

}
