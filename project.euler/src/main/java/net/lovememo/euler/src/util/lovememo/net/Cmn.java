package util.lovememo.net;

public class Cmn {
	public static void getPrimeFactor(int num, long[] record) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				record[i]++;
				num /= i;
				getPrimeFactor(num, record);
				return;
			}
		}
		record[num]++;
	}

	public static long calcExponential(long base, long exponential) {
		long ret = 1;
		for (long i = 0; i < exponential; i++) {
			ret *= base;
		}
		return ret;
	}

	/* 由质数幂形式表示的两个数相除top/bottom */
	public static long calcResult(long[] top, long[] bottom) {
		long result[] = top.clone();
		long sum = 1;
		for (int i = 2; i < bottom.length; i++) {
			if (bottom[i] != 0) {
				result[i] = result[i] - bottom[i];
			}
			if (result[i] != 0) {
				sum *= calcExponential(i, result[i]);
			}

		}
		return sum;
	}

	/* 幂指数相加 */
	public static long[] arrayAdd(long[] a, long[] b) {
		long[] retArr = new long[a.length];
		for (int i = 0; i < a.length; i++) {
			retArr[i] = a[i] + b[i];
		}
		return retArr;
	}

	public static int C2(int n, int r) {
		int top = 1;
		int bottom = 1;
		for (int i = 1; i <= r; i++) {
			top *= (n--);
			bottom *= i;
			if (top % bottom == 0) {
				top /= bottom;
				bottom = 1;
			}
		}

		return top;
	}
	
	/* 组合数算法 */
	public static long C(int n, int r) {
		long topPrimeArr[] = new long[100];
		long bottomPrimeArr[] = new long[100];
		for (int i = 1; i <= r; i++) {
			long tmpTop[] = new long[100];
			long tmpBottom[] = new long[100];
			getPrimeFactor(n--, tmpTop);
			getPrimeFactor(i, tmpBottom);
			topPrimeArr = arrayAdd(topPrimeArr, tmpTop);
			bottomPrimeArr = arrayAdd(bottomPrimeArr, tmpBottom);
		}
		// showPrime(topPrimeArr);
		// System.out.println("====");
		// showPrime(bottomPrimeArr);

		return calcResult(topPrimeArr, bottomPrimeArr);
	}

}
