package Problem01_25;

public class Problem9 {

	public static boolean isSolution(int a, int b, int c) {
		return a*a + b*b == c*c;
	}
	public static void main(String[] args) {
		for(int a = 1; a<1000; a++) {
			for(int b=1000; b>1; b--) {
				int c = 1000 - a -b;
				if(c<1)
					continue;
				if(isSolution(a, b, c)) {
					System.out.println("a:"+ a + ", b:" + b + ", c:" + c +", abc:"+a*b*c);
					return;
				}
			}
		}

	}

}
