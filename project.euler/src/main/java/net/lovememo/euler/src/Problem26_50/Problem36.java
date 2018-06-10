package Problem26_50;

public class Problem36 {
	
	public static boolean isPalindromes(String str) {
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i))
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long sum = 0;
		for(int num=1; num<=1000000; num++) {
			String strB = Integer.toBinaryString(num);
			String strT = Integer.toString(num);
			if(isPalindromes(strT) && isPalindromes(strB)) {
				sum += num;
			}
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
		
	}

}
