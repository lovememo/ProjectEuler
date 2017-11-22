package Problem51_75

import end
import start
import util.lovememo.net.EulerUtil

/* 3, 7, 109, and 673*/
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

fun main(args: Array<String>) {
    start()
    val count = 5
    val list = mutableListOf(3L)
    val list2 = mutableListOf(3L)
    /*start()
    list = mutableListOf(3L)
    genPrimePair(list, count)
    println(list)
    end()*/

    start()
    genPrimePair2(list2, count)
    println(list)
    end()

    /*var x = 3L
    var y = 3L
    while(true) {
        var z = "$x$y".toLong()
        var flag1 = Pair(x, y).isPrime()
        var flag2 = EulerUtil.simpleIsPrime(z)
        if(flag1 != flag2) {
            print("${Pair(x, y)}:$z --> ${flag1}  ${flag2}\r\n")
        }

        y+=2
    }
*/
}
