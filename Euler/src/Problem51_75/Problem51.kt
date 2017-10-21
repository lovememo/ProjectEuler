package Problem51_75

import util.lovememo.net.EulerUtil

/**
 * Created by lovememo on 17-10-16.
 * Prime digit replacements
Problem 51
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
13, 23, 43, 53, 73, and 83, are all prime.By replacing the 3rd and 4th digits of 56**3 with the same digit,
this 5-digit number is the first example having seven primes among the ten generated numbers,
yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003,
being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit,
is part of an eight prime value family.
 */

//看到的另一个思路，先产生素数，再用“---**-*---”类似这种模式去匹配，如果匹配正确，count + 1
val symbols = arrayOf("*", "-")
val digits = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

fun genSequence(n: Int): MutableList<String> {
    if (1 == n) {
        return symbols.toMutableList()
    }
    val retList = mutableListOf<String>()
    symbols.forEach { x -> genSequence(n - 1).forEach { y -> retList.add(x + y) } }
    return retList
}

fun hit(str: String): Boolean {
    if (str.last() in arrayOf('0', '2', '4', '5', '6', '8')) {//not prime number
        return false
    }

    val numbers = digits.map { Integer.valueOf(str.replace(symbols[0], it.toString())).toLong() }.filter{it.toString().length == str.length}
    val count = numbers.count { EulerUtil.simpleIsPrime(it) }
    if (7 == count) {
        println(numbers.filter { EulerUtil.simpleIsPrime(it) })
    }
    if (8 == count) {
        println("---->>$str<<----")
        println(numbers.filter { EulerUtil.simpleIsPrime(it) })
        return true
    }
    return false

}

fun getTmpNumSeq(symbolStr: String, n: Int): MutableList<String> {
    var retList = mutableListOf<String>()
    var curChar = symbolStr[n]
    if (n == symbolStr.length - 1) {
        if (curChar == '-') {
            digits.forEach {
                var tmpSymbolStr = symbolStr.replaceRange(n, n + 1, it.toString())
                retList.add(tmpSymbolStr)
                if (hit(tmpSymbolStr)) {
                    return retList
                }
            }
        } else {
            retList.add(symbolStr)
            if (hit(symbolStr))
                return retList
        }
        return retList
    }

    if (curChar == '-') {
        digits.forEach {
            var tmpSymbolStr = symbolStr.replaceRange(n, n + 1, it.toString())
            retList.addAll(getTmpNumSeq(tmpSymbolStr, n + 1))
        }
    } else {

        retList.addAll(getTmpNumSeq(symbolStr, n + 1))
    }
    return retList

}

fun main(args: Array<String>) {
    EulerUtil.start()
    var n = 2
    while (true) {
        genSequence(n++)//generate "---**-*---" sequence
                .forEach {
                    getTmpNumSeq(it, 0)//generate "454**3*451" sequence
                }

    }
    EulerUtil.end()

}
