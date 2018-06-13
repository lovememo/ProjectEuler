package net.lovememo.euler.Problem51_75

import end
import start
import kotlin.math.pow

/**
 * Author: lovememo
 * Date: 18-6-13
 */
/**
 * Cubic permutations
 * Problem 62
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */
fun main(args: Array<String>) {
    val map = emptyMap<String, MutableList<Long>>().toMutableMap()
    start()
    try {
        for (i in 1..9999) {
            val cube = i.pow(3)
            if (map.hit(cube)) {
                println("${map[cube.getFeature()]}")
                return
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {

        end()
    }
}
fun Int.pow(index:Int): Long {
    return this.toDouble().pow(3).toLong()
}
fun MutableMap<String, MutableList<Long>>.hit(cube: Long): Boolean {
    val key = cube.getFeature()
    val maxCount = 5
    if (this.containsKey(key)) this[key]!!.add(cube) else this[key] = mutableListOf(cube)
    return this[key]!!.size >= maxCount
}

fun Long.getFeature(): String {
    val feature = Array(10, {0})
    this.toString()
            .chars()
            .forEach { feature[it - '0'.toInt()] ++ }
    return feature.map{it.toString()}
            .reduce{a, b -> "$a$b"}

}