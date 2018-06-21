package net.lovememo.euler.Problem51_75
import end
import net.lovememo.euler.util.EulerUtil
import start
import java.math.BigInteger

/**
 * Author: lovememo
 * Date: 18-6-19
 */

/**
 * Diophantine equation
 * Problem 66
 * Consider quadratic Diophantine equations of the form:
 *
 * x^2 - Dy^2 = 1
 *
 * For example, when D=13, the minimal solution in x is 649^2 - 13*180^2 = 1.
 *
 * It can be assumed that there are no solutions in positive integers when D is square.
 *
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 *
 * 3^2 - 2*2^2 = 1
 * 2^2 - 3*1^2 = 1
 * 9^2 - 5*4^2 = 1
 * 5^2 - 6*2^2 = 1
 * 8^2 - 7*3^2 = 1
 *
 * Hence, by considering minimal solutions in x for D * 7, the largest x is obtained when D=5.
 *
 * Find the value of D * 1000 in minimal solutions of x for which the largest value of x is obtained.
 */


fun main(args: Array<String>) {
    start()
    val result = calcDsUnder(1000L)
            .map { it to calcSolution(calcPeriod(it.toInt()).removeLast().toTypedArray()).first }

    result.forEach { println("d is ${it.first}, x is ${it.second}") }
    val hit = result.maxBy { it.second }
    println("d is ${hit!!.first}, max x is :${hit!!.second}")
    end()
}

fun calcDsUnder(maxNum:Long): Array<Long> {
    val array = Array(maxNum.toInt(), {(it + 1).toLong()})
    val squareArray = array.map {it * it}
    return (array.map{it}.minus(squareArray)).toTypedArray()
}

fun calcSolution(array:Array<Int>):Pair<BigInteger, BigInteger> {
    var p = BigInteger.valueOf(array[array.size-1].toLong())
    var q = BigInteger.ONE
    for( i in 0 until array.size - 1 ) {
        var next = BigInteger.valueOf(array[array.size - 2 - i].toLong())
        var swap = p
        p = q
        q = swap

        p = q * next + p
    }
    var x = p
    var y = q
    if(!EulerUtil.isEvenNum(array.size - 2)) {
        val two = BigInteger.valueOf(2L)
        val one = BigInteger.ONE
        x = p * p * two + one
        y = two * p * q
    }
    return x to y
}