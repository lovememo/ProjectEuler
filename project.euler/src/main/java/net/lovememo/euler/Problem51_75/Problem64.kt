package net.lovememo.euler.Problem51_75

import end
import start
import kotlin.math.pow

/**
 * Author: lovememo
 * Date: 18-6-13
 */
fun main(args: Array<String>) {
    start()
    val count = Array(10000,{it + 1})
            .filter{notSquare(it)}
            .map{calcPeriod(it)}
            .map{it.size - 1}
            .filter { it%2==1 }
            .count()
    println("count$count")

    println(calcPeriod(23))
    end()

//    arrayOf(2,3,5,6,7,8,10,11,12,13).toIntArray().filter{ x->Ma}
//    println(calcPeriod(23))
//    println("${start.roundPart} + $start   ${start.getFeature()}")
}

val notSquare:(Int)->Boolean = {
    Math.pow(Math.sqrt(it.toDouble()).toInt().toDouble(), 2.0) != it.toDouble()
}

fun <E> MutableList<E>.removeLast(): MutableList<E> {
    this.removeAt(this.size-1)
    return this
}

fun calcPeriod(num:Int):MutableList<Int> {
    val list = emptyList<Int>().toMutableList()
    val round = Math.sqrt(num.toDouble()).toInt()
    var start = SqrtFrac(SqrtNum(num, 1, -round), SqrtNum(num,0, 1))
    start.roundPart = round
    val map = emptyMap<String, Int>().toMutableMap()
    while(!calcOnePeriod(start, map, list)) {}
    return list
}

fun calcOnePeriod(frac:SqrtFrac, map:MutableMap<String,Int>, list:MutableList<Int>): Boolean {
    frac.reciprocal() //求倒
    frac.rationalize() //有理化
    list.add(frac.roundPart)
    frac.calc()

    val feature = frac.getFeature()
    return if(map.containsKey(feature)) {
        true
    } else {
        map[feature] = 1
        false
    }

}
fun test() {
    var a = SqrtNum(3, 0, 2)
    var b = SqrtNum(3, 2, 3)

    println(a)
    println(b)
    println(a + b)
    println("----------")
    println(b)
    println(b.conjugate())
    println(b * b.conjugate())

    var frac = SqrtFrac(a, b)
    println(frac)
//    println(frac.reciprocal().calcRoundPart())

}
class SqrtFrac constructor(var top: SqrtNum = SqrtNum(1, 0, 1), var bottom: SqrtNum = SqrtNum(1, 0, 1)) {
    var roundPart:Int = 0
    init {

    }

    fun getFeature(): String {
        return "$roundPart${this.top.a}${this.top.b}${this.bottom.a}${this.bottom.b}"
    }
    private fun calcRoundPart():Int {
        this.roundPart = Math.floor(this.top.calcValue() / this.bottom.calcValue()).toInt()
        return this.roundPart
    }

    fun calc() {
        val round = this.calcRoundPart()
        if(round == 0) {
            return
        }
        this.top = this.top - this.bottom * round
    }

    /**
     * 求倒数
     */
    fun reciprocal(): SqrtFrac {
        val swap = this.top
        this.top = this.bottom
        this.bottom = swap
        return this
    }

    /**
     * 有理化
     */
    fun rationalize(): SqrtFrac {
        if (bottom.a == 0)
            return this
        val conjugate = this.bottom.conjugate()
        this.top = this.top * conjugate
        this.bottom = this.bottom * conjugate
        if(this.top.a != 1) {
            this.top.b /= this.top.a
            this.bottom.a /= this.top.a
            this.bottom.b /= this.top.a
            this.top.a = 1
        }
        return this
    }

    override fun toString(): String {
        val topStr: String = if (top.a == 0) "$top" else "($top)"
        val bottomStr: String = if (bottom.a == 0) "$bottom" else "($bottom)"
        val roundPart:String = if(this.roundPart != 0) "${this.roundPart} + " else ""

        return "$roundPart$topStr/$bottomStr"
    }
}

class SqrtNum constructor(var unit: Int, var a: Int, var b: Int) {
    override fun toString(): String {
        return if (a == 0) "$b" else (if (b < 0) "$a√$unit - ${-b}" else "$a√$unit + $b")
    }

    fun calcValue(): Double {
        return this.unit.toDouble().pow(0.5) * this.a.toDouble() + this.b.toDouble()
    }
    /**
     * 共轭
     */
    fun conjugate(): SqrtNum {
        return SqrtNum(this.unit, this.a, -this.b)
    }

    fun clone(): SqrtNum {
        return SqrtNum(this.unit, this.a, this.b)
    }
}

fun assertSameUnit(a: SqrtNum, b: SqrtNum) {
    if (a.unit != b.unit) {
        throw IllegalArgumentException("unit should be equal √${a.unit} != √${b.unit}")
    }
}

operator fun SqrtNum.plus(num: SqrtNum): SqrtNum {
    assertSameUnit(this, num)
    return SqrtNum(this.unit, this.a + num.a, this.b + num.b)
}

operator fun SqrtNum.times(num: SqrtNum): SqrtNum {
    assertSameUnit(this, num)
    var a = this.a * num.b + this.b * num.a
    var b = this.a * num.a * this.unit + this.b * num.b
    return SqrtNum(this.unit, a, b)
}

operator fun SqrtNum.times(num:Int): SqrtNum {
    return SqrtNum(this.unit, a*num, b*num)
}

operator fun SqrtNum.minus(num: SqrtNum): SqrtNum {
    assertSameUnit(this, num)
    return SqrtNum(this.unit, this.a - num.a, this.b - num.b)
}