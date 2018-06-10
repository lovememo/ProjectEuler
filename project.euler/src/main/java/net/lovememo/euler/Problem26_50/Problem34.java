package net.lovememo.euler.Problem26_50;

public class Problem34 {
	private static int[] factorials = new int[9];
	private static int getFactorialsAt(int i) {
		if(i==1) {
			factorials[i-1] = 1;
			return 1;
		} else {
			if(factorials[i-1] == 0)
				factorials[i-1] = getFactorialsAt(i-1) * i;
			return factorials[i-1];
		}
	}
	static {
		getFactorialsAt(9);
	}
	
	/**����n�Ľ׳�1-9*/
	public static int getFactorials(int n) {
		if(n==0)
			return 1;
		
		if(n>9 || n<0)
			return -1;
		
		return factorials[n-1];
	}
	
	/**
	 * @param n
	 * @return
	 * ����10��n�η�
	 */
	public static int get10nValue(int n) {
		int sum = 1;
		for(int i=1; i<=n; i++) {
			sum *= 10;
		}
		return sum;
	}
	
	/**
	 * @param num
	 * @return
	 * ������num��λ�Ͻ׳�ֵ�ĺ�
	 */
	public static int getFactorialSum(int num) {
		int sum = 0;
		int digit;
		while(num != 0) {
			digit = num - num/10*10;
			sum += getFactorials(digit);
			num /= 10;
		}		
		return sum;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int MAX_DIGITS = 1;
		while(get10nValue(MAX_DIGITS - 1) < MAX_DIGITS*getFactorials(9) ) {
			MAX_DIGITS ++;
		}
		int MAX_VALUE = get10nValue(MAX_DIGITS - 1);
		
		int sum = 0;
		for(int i=1; i<=MAX_VALUE; i++) {
			if(i == getFactorialSum(i) && i!=1 && i!=2)
				sum += i;			
		}
		System.out.println("sum is: " + sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endTime - startTime) + "ms");
	}
}
