package Problem26_50;


public class Problem41 {
	//判断素数
	private static boolean isPrime(long num) {
		if(num == 2)
			return true;
		if(num%2 == 0)
			return false;
		for(int i=3; i*i<=num; i+=2) {
			if(num%i == 0)
				return false;
		}
		return true;
	}
	
	//计算一个数字的位数
	public static int digitNum (long num) {
		int counts = 0;
		while (num != 0) {
			num /= 10;
			counts ++;
		}
		return counts == 0 ? 1 : counts;
	}
	
	//把一个数字转为数组
	public static int[] getNumArr(long num) {
		int[] retArr = new int[digitNum(num)];
		for(int i=0; i<retArr.length; i++) {
			retArr[retArr.length - 1 - i] = (int) (num - num / 10 * 10);
			num /= 10;
		}
		return retArr;
	}
	
	//判断一个数是否为pandigital数
	private static boolean filterPandigital(int[] numArr) {
		int[] table = new int[10];
		for(int i=0; i<numArr.length; i++) {
			table[numArr[i]] ++;
			if(table[numArr[i]] > 1)
				return false;
		}
		for(int i=1; i<=numArr.length; i++) {
			if(table[i] != 1)
				return false;
		}
		return true;
	}
	
	public static boolean filterPandigital(long num) {
		int[] numArr = getNumArr(num);
		return filterPandigital(numArr);
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for(long i=987654321L; i>=2; i--) {
			if(filterPandigital(i)) {
				if(isPrime(i)) {
					System.out.println(i);
					break;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
		//7652413
		//95585ms
	}
}
