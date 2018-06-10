package net.lovememo.euler.Problem01_25;

public class Problem4 {
	public static boolean isPalindrome(int intNum) {
		String strNum = Integer.toString(intNum);
		int halfLength = (strNum.length()+1) / 2;
		for(int i=0; i<halfLength; i++) {
			if(strNum.charAt(i) != strNum.charAt(strNum.length()-1-i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int maxNum = 0;
		int m = 0;
		int n = 0;
		for(int i=999; i>900;i--) {
			for(int j=999; j>=i; j--) {
				int num = i * j;
				if(Problem4.isPalindrome(num)) {
					if(num > maxNum) {
						maxNum = num;
						m = i;
						n = j;
					}
				}
			}
		}
		System.out.println(maxNum + ": " + m + "*" + n);
	}
}
