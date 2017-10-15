/**
 * Created by lovememo on 17-10-15.
 *
Square root convergents
Problem 57
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

√ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...

By expanding this for the first four iterations, we get:

1 + 1/2 = 3/2 = 1.5
1 + 1/(2 + 1/2) = 7/5 = 1.4
1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...

The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first
example where the number of digits in the numerator exceeds the number of digits in the denominator.
In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */

/**
 * return digits of Long number
 */
fun Long.digits(): Int {
    val s = this.toString()
    return s.length
}

class Fraction(val numerator: Long, val denominator: Long) {
    operator fun plus(frac: Fraction?): Fraction {
        if(null == frac) {
            return this
        }
        val retDenominator = lcm(frac.denominator, this.denominator)//分母为最小公倍数
        val retNumerator = retDenominator / this.denominator * this.numerator + retDenominator / frac.denominator * frac.numerator
        return Fraction(retNumerator, retDenominator).simplize()
    }

    fun simplize(): Fraction {
        val gcdValue = gcd(this.numerator, this.denominator)
        return Fraction(this.numerator / gcdValue, this.denominator / gcdValue)
    }

    override fun toString(): String {
        return this.numerator.toString() + "/" + this.denominator.toString()
    }
    //倒数
    fun reciprocal(): Fraction{
        return Fraction(this.denominator, this.numerator).simplize()
    }
}

/**
 * 获取最大公约数
 */
fun gcd(a: Long, b: Long): Long {
    if (a < b) {
        return gcd(b, a)
    }
    var aa = a
    var bb = b
    var m = aa % bb
    while (0L != m) {
        aa = bb
        bb = m
        m = aa % bb
    }
    return bb
}

operator fun Long.plus(frac: Fraction?): Fraction {
    val thisFrac = Fraction(this, 1)
    return thisFrac + frac
}
/**
 * 获取最小公倍数
 */
fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
}
val dataTable = mutableMapOf<Int, Fraction>()

fun calcSub(n:Int): Fraction? {
    if(0 == n) {
        if(null == dataTable[n]) {
            dataTable[n] = Fraction(1,2)
        }
        return dataTable[n]
    }
    if(null == dataTable[n]) {
        dataTable[n] = (2L + calcSub(n-1)).reciprocal()
    }
    return dataTable[n]
}

fun calcSqrt2Val(n: Int): Fraction {
    return 1L + calcSub(n)
}


fun main(args: Array<String>) {
    dataTable.clear()
    var count = 0
    for(n in 0..1000-1) {
        var sqrt2 = calcSqrt2Val(n)
        if(sqrt2.numerator.digits() > sqrt2.denominator.digits()) {
            count ++
            println(sqrt2)
        }
    }
    println(count)
}