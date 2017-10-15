package Problem51_75

import util.lovememo.net.EulerUtil

/**
 * Created by lovememo on 17-10-15.
 *Spiral primes
Problem 58
Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

_37 36 35 34 33 32 _31
38 _17 16 15 14 _13 30
39 18  _5  4  _3 12 29
40 19  6  1  2 11 28
41 20  _7  8  9 10 27
42 21 22 23 24 25 26
_43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 */

val direction = arrayListOf("x" to 1, "y" to 1, "x" to -1, "y" to -1)

data class Point(var x:Int, var y:Int) {
    fun move(axis: String, step:Int): Int{
        if(axis.toUpperCase() == "X") {
            x += step
            return x
        } else if(axis.toUpperCase() == "Y") {
            y += step
            return y
        }
        return -1
    }
}

fun getDiagonalNums(sideLength:Int):MutableList<Long> {
    var diagonalNums = mutableListOf<Long>()
    var curNum = 1L
    var point = Point(0, 0)
    var dirIdx = 0
    diagonalNums.add(curNum)
    for(maxBoarder in 1..(sideLength - 1) / 2) {
        while(dirIdx % 4 != 0 || dirIdx ==0) {
            var curDirection = direction[dirIdx]
            var axisVal = point.move(curDirection.first, curDirection.second)
            curNum ++
            if(Math.abs(axisVal) == maxBoarder) {
                dirIdx += 1//change direction
            }
            if (Math.abs(point.x) == Math.abs(point.y)) {
                diagonalNums.add(curNum)
            }
        }
        dirIdx = 0
    }
    point.move("x", 1)
    curNum ++
    while(Math.abs(point.x) != Math.abs(point.y)) {
        point.move("x", 1)
        curNum ++
    }
    diagonalNums.add(curNum)
    return diagonalNums
}

fun main(args: Array<String>) {
    println(getDiagonalNums(30))
}
fun main2(args: Array<String>) {
    EulerUtil.isPrime(10000)
    println("prime calc done")
    var sideLength = 1500
    while(true) {
        var nums = getDiagonalNums(sideLength)
        var count = 0
        for (num in nums) {
            if (EulerUtil.isPrime(num)) {
                count++
            }
        }
        var ratio = count.toDouble() / nums.size.toDouble()
        println("ratio is $ratio, sideLength is $sideLength")
        if (ratio < 0.1) {
            println("sideLength is $sideLength")
            //break
        }
        sideLength ++
    }

}