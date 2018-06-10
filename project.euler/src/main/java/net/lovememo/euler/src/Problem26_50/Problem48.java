package Problem26_50;

public class Problem48 {
	
	private static int[] numberToArray(long num) {
		int[] retArr = new int[10];
		int i=0;
		while(num != 0) {
			if(i > 9)
				return retArr;
			retArr[i] = (int)(num - num / 10 * 10);
			num /= 10;			
			i ++;
		}
		return retArr;
	}
	
	private static int getTenDigits(int count) {
		int retNum = 1;
		for(int i=0; i<count; i++) {
			retNum *= 10;
		}
		return retNum;
	}
	
	private static long arrayToNumber(int[] arr) {
		long retNum = 0;		
		for(int i=0; i<arr.length; i++) {
			retNum += (long)arr[i] * (long)getTenDigits(i);
		}
		return retNum;
	}	
	
	private static int[] getPowerLastTenDigitsSub(int[] retArr, int num) {		
		for(int i=0; i<num-1; i++) {
			long number = arrayToNumber(retArr);
			retArr = numberToArray(number * num);
		}
		return retArr;
	}
	
	private static int[] getPowerLastTenDigits(int num) {
		int[] retArr = new int[10];
		retArr = numberToArray(num);
		retArr = getPowerLastTenDigitsSub(retArr,num);
		return retArr;
	}
	
	private static int[] getSumLastTenDigits(int[] arr1, int[] arr2) {
		int[] retArr = new int[10];
		for(int i=0; i<10; i++) {
			retArr[i] = arr1[i] + arr2[i];
		}
		for(int i=0; i<9; i++) {
			if(retArr[i] >= 10) {
				retArr[i] -= 10;
				retArr[i+1] ++;
			}
		}
		if(retArr[9] >= 10)
			retArr[9] -= 10;
		return retArr;
	}
	
	public static int[] getSeriesLastTenDigits(int number) {
		int[] retArr = new int[10];
		for(int i=1; i<=number; i++) {	
			int[] tmpArr = getPowerLastTenDigits(i);			
			retArr = getSumLastTenDigits(retArr,tmpArr);
		}
		return retArr;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arr = getSeriesLastTenDigits(1000);
		_debug_show_array(arr);
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
	}
	
	private static void _debug_show_array(int[] arr) {
		for(int i=9; i>=0; i--) {
			System.out.print(arr[i] + "");
		}
		System.out.println();
	}

}
