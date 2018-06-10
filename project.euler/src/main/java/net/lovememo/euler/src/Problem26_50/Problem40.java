package Problem26_50;

public class Problem40 {
	public static int[] getArray() {
		int[] newArr = new int[2000000];
		int num = 0;
		int curPos = 0;
		int[] subArray = null;
		while(curPos <1000001) {
			subArray = getSubArray(num);
			System.arraycopy(subArray, 0, newArr, curPos, subArray.length);
			curPos += subArray.length;
			num ++;
		}
		return newArr;
	}

	public static int digitNum (int num) {
		int counts = 0;
		while (num !=0) {
			num /= 10;
			counts ++;
		}
		return counts == 0 ? 1 : counts;
	}
	
	public static int[] getSubArray(int num) {
		int[] a = new int[digitNum(num)];
		for(int i=0; i<a.length; i++) {
			a[a.length - 1 - i] = num - num / 10 * 10;
			num /= 10;
		}
		return a;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] tmp = getArray();
		System.out.println(tmp[1]*tmp[10]*tmp[100]*tmp[1000]*tmp[10000]*tmp[1]*tmp[100000]*tmp[1000000]);
	}

}
