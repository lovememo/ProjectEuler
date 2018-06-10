package Problem01_25;

public class Problem16 {

	public static void main(String[] args) {
			int length = 302;
			int [] result = new int[length];
			result[0] = 1;
			
			for(int i=0; i<1000; i++) {
				for(int j=0; j<length; j++) {
					result[j] *= 2;
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


/*
2^1 2   2
2^2 4	4
2^4 16	7
2^5 32	5
-----------
2^5 = 2^4 * 2
	= 2^3 * 4
	= 2^2 * 8
	= 2^1 * 16 = 2^1 * (10 + 6)
	
	00 00 00 00 00 00 
	00 00 00 00 00 16 -> 00 00 00 00 01 06
	00 00 00 00 02 12 -> 00 00 00 00 03 02
	
	2^15 = 32768 = 16384 + 16384  
		3 + 2 + 7 + 6 + 8 = 26
	2^14 = 16384


3
1 1
5
1 0 1
7
1 1 1
9
1 0 0 1

11
1 1 0 1 -> 11==1011B



*/