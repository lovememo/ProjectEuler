package net.lovememo.euler.Problem26_50;
/*
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

	21 22 23 24 25
	20  7  8  9 10
	19  6  1  2 11
	18  5  4  3 12
	17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * */
public class Problem28 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int targetNum = 1001;
		int n = 1;
		int num = 1;
		int sum = 1;
		while(2*n+1 != targetNum+2) {
			for(int i=0; i<4; i++) {
				num = num + 2*n;
				sum += num;
			}
			n ++;
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("time used:�� " + (endTime - startTime) + "ms.");	

	}

}
