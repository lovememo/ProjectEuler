package net.lovememo.euler.Problem51_75

import end
import net.lovememo.euler.util.EulerUtil
import start
import util.lovememo.net.genPrimes
import util.lovememo.net.getNextPrime

/* 3, 7, 109, and 673*/
/*[3, 7, 109, 673, 129976621]*/
fun hit(list:MutableList<Long>, newNum:Long): Boolean {
    list.forEach {
        if(!EulerUtil.simpleIsPrime("$it$newNum".toLong())
                || !EulerUtil.simpleIsPrime("$newNum$it".toLong())) {
            return false
        }
    }
    return true
}

fun hit2(list:MutableList<Long>, newNum:Long): Boolean {
    list.forEach {
        if(!Pair(it, newNum).isPrime() || !Pair(newNum, it).isPrime()) {
            return false
        }
    }
    return true
}

fun hit3(list:MutableList<Long>, newNum:Long, primeArr:Array<Int>): Boolean {
    list.forEach {
        if(!Pair(it, newNum).isPrime(primeArr) || !Pair(newNum, it).isPrime(primeArr)) {
            return false
        }
    }
    return true
}

fun Pair<Long, Long>.isPrime():Boolean {
    val midNum = Math.sqrt("${this.first}${this.second}".toLong().toDouble()).toLong()
    if(this mod 2 == 0L) {
        return false
    }
    var i = 3L
    while( i <= midNum) {
        if (this mod i == 0L) {
            return false
        }
        i += 2
    }
    return true
}

fun Pair<Long, Long>.isPrime(primeArr:Array<Int>):Boolean {
    val newNum = "${this.first}${this.second}".toLong()
    if(newNum > primeArr.size.toLong() - 1) {
        println(newNum)
        println("maxNum:${Integer.MAX_VALUE}")
        throw Exception("too big")
    }

    return 1 == primeArr[newNum.toInt()]
}

infix fun Pair<Long, Long>.mod(other: Long): Long {
    val x = this.first
    val y = this.second
    val multiplier = Math.pow(10.0,y.toString().length.toDouble()).toLong()
    //real number is A = x * multiplier + y, our purpose is to calc value of A mod other
    return (multiplier % other * x % other + y % other) % other
}

fun genPrimePair(list: MutableList<Long>, count: Int) {
    if(count == list.size) {
        return
    }
    var newNum = list.last()
    var newNumStr = ""
    while(true) {
        newNum += 2
        newNumStr = newNum.toString()

        while(newNumStr.endsWith("5")
                || newNumStr.sumBy { it.toInt() } % 3 in listOf(0, 2)
                || !EulerUtil.simpleIsPrime(newNum)) {
            newNum += 2
            newNumStr = newNum.toString()
        }
        //println(newNum)
        if(hit(list, newNum)) {
            list.add(newNum)
            genPrimePair(list, count)
            return
        }
    }
}
fun genPrimePair2(list: MutableList<Long>, count: Int) {
    if(count == list.size) {
        return
    }
    var newNum = list.last()
    while(true) {
        newNum += 2
         if(!EulerUtil.simpleIsPrime(newNum)) {
            newNum += 2
        }
//        println(newNum)
        if(hit2(list, newNum)) {
            list.add(newNum)
            genPrimePair2(list, count)
            return
        }
    }
}

fun genPrimePair3(list: MutableList<Long>, count: Int, primeArr: Array<Int>, maxPrime:Long) {
        if(count == list.size) {
            return
        }
        var newNum = list.last()
        while(true) {
            if(newNum>maxPrime) {
                return
            }
            newNum = getNextPrime(newNum.toInt(), primeArr).toLong()
            //if(hit3(list, newNum, primeArr)) {
            //println(newNum)
            if(hit(list, newNum)) {
                list.add(newNum)
                genPrimePair3(list, count, primeArr, maxPrime)
                return
            }
        }
}




fun main(args: Array<String>) {
    /*println(3+7+ 109+ 673)
    println(792+ 129976621)
    start()
    println(EulerUtil.simpleIsPrime(3129976621L))
    println(EulerUtil.simpleIsPrime(7129976621L))
    println(EulerUtil.simpleIsPrime(109129976621L))
    println(EulerUtil.simpleIsPrime(673129976621L))
    println(EulerUtil.simpleIsPrime(1299766213L))
    println(EulerUtil.simpleIsPrime(1299766217L))
    println(EulerUtil.simpleIsPrime(129976621109L))
    println(EulerUtil.simpleIsPrime(129976621673L))
    println(EulerUtil.simpleIsPrime(129976621L))
*/

/*
    var x = genPrimes(129977416)

    println(x[129976621])
    end()

*/

    start()
//    var x = genPrimes(200000000)
    var x = genPrimes(200000000)
    end()
//    start()
//    var newNum = 129976609L
//    newNum = getNextPrime(newNum.toInt(), x).toLong()
//    println(EulerUtil.simpleIsPrime(129976621L))
//    println(newNum)
//
//    end()
    start()
    val count = 5
    var maxPrime = 200000000L
    for(i in 3 until x.size) {
        if(x[i]==0) {
            continue
        }
        if(i > maxPrime) {
            return
        }
        start()
        var list = mutableListOf(i.toLong())

        genPrimePair3(list, count, x, maxPrime)
        if(list.size == 5) {
            maxPrime = if (maxPrime > list[4])  list[4] else maxPrime
            print(list)
            print("  ")
            end()
        }


    }




    end()
}
