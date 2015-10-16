package Problem51_75;

import java.math.BigInteger;

import util.lovememo.net.Fraction;



public class Problem65 {
 
 //循环的因子，n从1开始，生成1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...序列
 public static long Q(long n) {
  if(n == 0)
   return 2;  
  long rem = (long)n % 3;
  if(rem == 1 || rem == 0)
   return 1;
  if(rem == 2) {
   long tmp = (long)n / 3 + 1;
   return tmp * 2;
  }
  return -1;
 }
 
 public static Fraction getConvergentFraction(long n) {
	 Fraction S = new Fraction(Q(n));
	 while(n >= 1) {
		 S = new Fraction(Q(n-1)).add(S.turnReciprocal());
		 n --;
	 }
	 return S;
 }
 
 /**
  * @param args
  */
 public static void main(String[] args) {
	 String numerator = getConvergentFraction(99).getNumerator().toString();
	 
	 int sum = 0;
	 for(int i=0; i<numerator.length(); i++) {
		 int num = Integer.parseInt(new String(new char[] { numerator.charAt(i)}));
		 sum += num;		 
	 }
	 System.out.println(sum);
 }
 
}

