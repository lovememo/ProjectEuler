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
val symbols = arrayOf("*", "-")

fun genSequence(n: Int): MutableList<String> {
    if (1 == n) {
        return symbols.toMutableList()
    }
    val retList = mutableListOf<String>()
    symbols.forEach { x -> genSequence(n - 1).forEach { y -> retList.add(x + y) } }
    return retList
}

val digits = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
fun getTmpNumSeq(symbolStr: String, n: Int): MutableList<String> {
    var retList = mutableListOf<String>()
    var curChar = symbolStr[n]
    if (n == symbolStr.length - 1) {
        if (curChar == '-') {
            digits.forEach {
                var tmpSymbolStr = symbolStr.replaceRange(n, n + 1, it.toString())
                retList.add(tmpSymbolStr)
            }
        } else {
            retList.add(symbolStr)
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
    genSequence(3).forEach { getTmpNumSeq(it, 0).forEach { println(it) } }

    EulerUtil.end()
    var x = "12a3"
    x = x.replaceRange(2, 3, "x")
    println(x)
}