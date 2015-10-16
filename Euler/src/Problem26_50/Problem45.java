package Problem26_50;

public class Problem45 {

	private static long T(long n) {
		return n * (n + 1L) / 2L;
	}

	private static long P(long n) {
		return n * (3L * n - 1L) / 2L;
	}

	private static long H(long n) {
		return n * (2L * n - 1L);
	}

	private static boolean search(long[] array, long objNum, int startIndex,
			int endIndex) {
		if (endIndex < startIndex)
			return false;
		int midIndex = (startIndex + endIndex) / 2;
		long midNum = array[midIndex];
		if (midNum == objNum)
			return true;

		return objNum < midNum ? search(array, objNum, startIndex, midIndex - 1)
				: search(array, objNum, midIndex + 1, endIndex);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int length = 100000;
		long[] Tn = new long[length];
		long[] Pn = new long[length];
		long[] Hn = new long[length];
		for (int i = 0; i < length; i++) {
			Tn[i] = T(i + 1);
			Pn[i] = P(i + 1);
			Hn[i] = H(i + 1);
		}

		for (int i = 0; i < length; i++) {
			long triNum = Tn[i];
			if (!search(Pn, triNum, 0, Pn.length - 1))
				continue;
			if (!search(Hn, triNum, 0, Hn.length - 1))
				continue;
			System.out.println(triNum);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Time used: " + (endTime - startTime) + "ºÁÃë");

	}

}
