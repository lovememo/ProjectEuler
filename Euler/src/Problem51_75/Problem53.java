package Problem51_75;


public class Problem53 {

	/**
	 * There are exactly ten ways of selecting three from five, 12345: 123, 124,
	 * 125, 134, 135, 145, 234, 235, 245, and 345 In combinatorics, we use the
	 * notation, 5C3= 10. In general, nCr= n! ------ r!(n-r)! ,where r<=n, n! =
	 * n*(n-1)...3*2*1, and 0! = 1. It is not until n= 23, that a value exceeds
	 * one-million: 23C10= 1144066. How many, not necessarily distinct, values
	 * of nCr, for 1<=n<=100, are greater than one-million? --------------- nCr=
	 * n! ------ r!(n-r)! = n(n-1)(n-2)...(n-r+1)(n-r)(n-r-1)...1
	 * -------------------------------------- r(r-1)...1*(n-r)(n-r-1)...1 =
	 * n(n-1)(n-2)...(n-r+1) --------------------- r(r-1)...1
	 **/

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

	public static void showPrime(long[] primeFactorTab) {
		for (int i = 0; i < primeFactorTab.length; i++) {
			long fac = primeFactorTab[i];
			if (fac != 0) {
				System.out.println("质数： " + i + ", 幂： " + fac);
			}
		}
	}

	public static void main(String[] args) {
		int sum = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 1; r <= n; r++) {
				if (C(n, r) >= 1000000) {
					sum += (n - 2 * r + 1);
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
