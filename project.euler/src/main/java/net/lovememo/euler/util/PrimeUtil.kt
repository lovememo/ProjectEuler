package util.lovememo.net

import net.lovememo.euler.util.EulerUtil.end
import net.lovememo.euler.util.EulerUtil.start

fun genPrimes(n: Int): Array<Int> {
    val rawNums = Array<Int>(n+1, {1})
    rawNums[0] = 0
    rawNums[1] = 0
    rawNums[2] = 1//2是素数

    for(i in 2..n) {
        if(rawNums[i] == 0) {
            continue
        }
        val count = (n / i).toInt()
        for( j in 2 .. count) {
           rawNums[j * i] = 0
        }
    }
    //rawNums.forEach { println(it) }
    return rawNums
}

fun getNextPrime(curNum:Int, primeArr:Array<Int>): Int {
    if(curNum + 1 > primeArr.size -1) {
        throw Exception("$curNum out of primeArr range")
    }
    for(i in curNum + 1 .. primeArr.size -1) {
        if(1 == primeArr[i]) {
            return i
        }
    }
    return -1
}

fun main(args: Array<String>) {
    start()
    var x = genPrimes(100000000)
    //var x = genPrimes(100)
    for(i in 0.. 100 ) {
        if(x[i] == 1)
            println(i)
    }

    println(getNextPrime(998, x))
    end()
}