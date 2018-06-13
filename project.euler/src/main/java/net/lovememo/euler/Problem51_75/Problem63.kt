package net.lovememo.euler.Problem51_75

import digits
import end
import start
import java.math.BigInteger
import kotlin.math.pow

/**
 * Powerful digit counts
 * Problem 63
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */

/**
 * analysis
 * Define function digits(n) results the digits of num
 * Notice digits(10^n) = n + 1
 * if Y > 10 then Y^n > 10^n (n is greater than zero)
 * then digits(Y^n) > digits(10^n) = n + 1
 *
 * so if Y^n has n digits, Y must be less then 10
 *
 * 用夹逼的方法获取任意数的位数
 * if 10^(n-1) < 9^X < 10^n then
 * digits(10^(n-1)) <= digits(9^X) < digits(10^n)
 * that is n <= digits(9^X) < n + 1
 * that is digits(9^X) = n
 * let X = n, then we get:
 * 10^(n-1) < 9^n < 10^n
 * we can find all 9-based n-powered n-digits numbers from "10^(n-1) < 9^n < 10^n"
 * by simple loop we can found max value of n throw "9^n < 10^n"
 */

/**
 * Author: lovememo
 * Date: 18-6-13
 */
fun main(args: Array<String>) {
    start()
    var count = 0
    for(base in 1..9) {
        for(index in 1..21) {
            val result = base.bigPow(index)
            val digits = result.digits()
            if(digits == index) {
                println("$base ^ $index = $result")
                count ++
            }
        }
    }
    println(count)
    end()
}

fun BigInteger.digits():Int {
    return this.toString().length
}

fun Int.bigPow(index:Int): BigInteger {
    val me = BigInteger.valueOf(this.toLong())
    return me.pow(index)
}