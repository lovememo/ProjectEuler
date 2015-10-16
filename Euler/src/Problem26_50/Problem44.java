package Problem26_50;

/**
 * n(3n-1)/2
 * */
public class Problem44 {
	/*
	 * delta = b2-4ac [-b+-sqrt(delta)]/(2a) 求解ax^2 + bx + c = 0 的解
	 * 
	 * @return 数组，第一个值为-1，表示无解，否则第二个第三个值为解
	 */
	private static long[] calcFormula(long a, long b, long c) {
		long[] answers = new long[3];
		long delta = b * b - 4 * a * c;
		if (delta < 0)
			answers[0] = -1;
		else {
			answers[0] = 0;
			double sqrtDelta = Math.sqrt(delta);
			answers[1] = (long) (((-1l) * b + sqrtDelta) / (2l * a));
			answers[2] = (long) (((-1l) * b - sqrtDelta) / (2l * a));
		}
		return answers;
	}

	/**
	 * 求解P(n)
	 */
	private static long P(long n) {
		return n * (3l * n - 1l) / 2l;
	}

	/**
	 * 判断一个数是否为一个P数
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static boolean isPNum(long sum) {
		long[] ans = calcFormula(3l, -1l, -2l * sum);
		if (ans[0] == -1)
			return false;
		if (P(ans[1]) == sum && ans[1] > 0) {
			return true;
		}
		if (P(ans[2]) == sum && ans[2] > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断P(s)是否为某两个P数的差
	 */
	private static boolean isDiffOfP(long s) {
		long num = P(s);
		long m, k, diff, beginIndex;
		beginIndex = 1l;
		for (m = 0; true; m++) {
			if (P(beginIndex + 1 + m + 1) - P(beginIndex + 1 + m) > num)
				break;

			for (k = 1; true; k++) {
				long num1 = P(beginIndex + 1 + m);
				long num2 = P(beginIndex + 1 + m + k);
				diff = num2 - num1;
				if (diff > num)
					break;
				if (diff == num) {

					long sum = num1 + num2;

					if (num1 < 0 || num2 < 0 || sum < 0) {
						System.out.println("error");
						return false;
					}
					if (isPNum(sum)) {
						System.out.print("==>s:" + s + " P(s): " + num + " x："
								+ (beginIndex + 1 + m) + " P(x): " + num1
								+ " y：" + (beginIndex + m + 1 + k) + " P(y): "
								+ num2 + " sum: " + sum + " diff: " + diff);
						System.out.println(" <===SUCCESS!");
						return true;
					}
//					break;
//					return false;
				}
			}
		}
		return false;
	}
	
	public static void find() {
		long max = 3000l;
		long minVal = 999999999999999l;
		long diff, sum;
		long num1, num2;
		for(long i=1; i<max; i++) {
			for(long j=i+1; j<max; j++) {
				num1 = P(i);
				num2 = P(j);
				sum  = num2 + num1;
				diff = num2 - num1;
				if(!isPNum(diff))
					continue;
				if(!isPNum(sum))
					continue;
				
				minVal = diff < minVal ? diff : minVal;
			}
		}
		System.out.println(minVal);
	}

	public static void main(String[] args) {
		//算法1 （0.2秒左右）
		long startTime = System.currentTimeMillis();
		/*for (long i = 1; i < 10000l; i++) {
			if (isDiffOfP(i))
				break;
		}*/
		find();
		long endTime = System.currentTimeMillis();

		System.out.println("Time used: " + (endTime - startTime) + "毫秒");
		
		//算法2 （46秒左右）
		startTime = System.currentTimeMillis();
		for (long i = 1; i < 10000l; i++) {
			if (isDiffOfP(i))
				break;
		}
		endTime = System.currentTimeMillis();

		System.out.println("Time used: " + (endTime - startTime)/1000 + "秒");
	}
}
