package net.lovememo.euler.Problem51_75

/**
 * Author: lovememo
 * Date: 18-6-13
 */
fun main(args: Array<String>) {
    var a = SqrtNum(3, 0, 2)
    var b = SqrtNum(3, 2, 3)

    println(a)
    println(b)
    println(a + b)
    println("----------")
    println(b)
    println(b.conjugate())
    println(b * b.conjugate())

    var frac = SqrtFrac(0, a, b)
    println(frac)
    println(frac.reciprocal())

}

class SqrtFrac constructor(var roundPart:Int=0, var top: SqrtNum = SqrtNum(1, 0, 1), var bottom: SqrtNum = SqrtNum(1, 0, 1)) {
    /**
     * 求倒数
     */
    fun reciprocal(): SqrtFrac{
        var swap: SqrtNum = this.top
        this.top = this.bottom
        this.bottom = swap
        return this
    }

    fun rationalize():SqrtFrac {
        if(bottom.a == 0)
            return this

        return this
    }

    override fun toString(): String {
        val topStr: String = if (top.a == 0) "$top" else "($top)"
        val bottomStr: String = if (bottom.a == 0) "$bottom" else "($bottom)"
        return "$topStr/$bottomStr"
    }
}

class SqrtNum constructor(var unit: Int, var a: Int, var b: Int) {
    override fun toString(): String {
        return if (a == 0) "$b" else (if(b<0) "$a√$unit - ${-b}" else "$a√$unit + $b")
    }

    /**
     * 共轭
     */
    fun conjugate(): SqrtNum{
        return SqrtNum(this.unit, this.a, -this.b)
    }
}

fun assertSameUnit(a:SqrtNum, b:SqrtNum) {
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

