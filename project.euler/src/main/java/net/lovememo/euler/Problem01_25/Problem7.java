package net.lovememo.euler.Problem01_25;

import net.lovememo.euler.util.EulerUtil;

public class Problem7 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		
		EulerUtil.getPrimesSizeof(10001);
		System.out.println(EulerUtil.getPrimeList().get(10000));	
		
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
	}
}
