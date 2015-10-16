package util.lovememo.net;

import java.math.BigInteger;

public class Fraction {
	private BigInteger numerator = BigInteger.ONE;//����
	private BigInteger denominator = BigInteger.ONE;//��ĸ	
	
	public Fraction(long n) {
		this.numerator = BigInteger.valueOf(n);
		
		this.denominator = BigInteger.ONE;		
	}
	
	public Fraction(long n, long d) {
		this.numerator = BigInteger.valueOf(n);
		this.denominator = BigInteger.valueOf(d);
	}
	
	public Fraction(BigInteger n, BigInteger d) {
		this.numerator = n;
		this.denominator = d;
	}
	
	/**
	 * ��������һ���������
	 * */
	public Fraction add(Fraction f) {
		BigInteger numerator = f.getNumerator().multiply(this.getDenominator()).add(
				this.getNumerator().multiply(f.getDenominator())
						);
		BigInteger denominator = f.getDenominator().multiply(this.denominator);
		return new Fraction(numerator, denominator);
	}
	
	/**
	 * ��������һ���������
	 * */
	public Fraction add(long n) {
		Fraction f = new Fraction(n);
		return this.add(f);
	}
	
	/**
	 * תΪ����
	 * */
	public Fraction turnReciprocal() {
		BigInteger tmp = this.numerator;
		this.numerator = this.denominator;
		this.denominator = tmp;
		return this;
	}
	
	/**
	 * ��ӡ
	 * */
	public void print() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		return this.numerator + "/" + this.denominator;		
	}
	
	public BigInteger getNumerator() {
		return numerator;
	}
	
	public void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}
	
	public BigInteger getDenominator() {
		return denominator;
	}
	
	public void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}
}