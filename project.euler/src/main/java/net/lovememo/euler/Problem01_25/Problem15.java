package net.lovememo.euler.Problem01_25;

public class Problem15 {

	public static void main(String[] args) {
		long top = 1L;
		long bottom = 1L;
		long para =20L;
		for(long i=1; i<para+1L; i++) {
			top *= i + para;
			bottom *= i;
			if(top%bottom == 0) {
				top /= bottom;
				bottom = 1;
			}
		}
		System.out.println(top);

	}

}

/*
4*5*6
-----------
1*2*3
*/