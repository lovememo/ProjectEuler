package Problem51_75

import util.lovememo.net.EulerUtil
import util.lovememo.net.FileUtil

fun readData(): MutableList<Array<Array<String>>> {
    val dataList: List<String> = FileUtil.getData("/Euler/src/Problem51_75/p054_poker.txt")
    val retList = mutableListOf<Array<Array<String>>>()
    dataList.forEach {
        val tmpList: List<String> = it.split(" ")
        retList.add(arrayOf(tmpList.subList(0, 5).toTypedArray(), tmpList.subList(5, 10).toTypedArray()))
    }
    return retList
}

fun <A> Array<A>.toMapWithValueAsKey(): Map<A, Int> {
    val retMap = mutableMapOf<A, Int>()
    this.forEachIndexed { index, el -> retMap.put(el, index + 10) }
    return retMap
}

val valTableMap = arrayOf('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A').toMapWithValueAsKey()

fun Array<String>.sortByDEcedingCardValue(): Array<String> {
    this.sortByDescending { valTableMap[it[0]] }
    return this
}

fun Array<String>.toMapWithCardValue(): Map<Char, Int> {
    val retMap = mutableMapOf<Char, Int>()
    this.distinctBy { it[0] }.forEach { x -> retMap.put(x[0], this.count { y -> x[0] == y[0] }) }
    return retMap
}

fun Array<String>.compareToAnotherPlayer(anotherArray: Array<String>): Int {
    val thisRank = this.calcRank()
    val otherRank = anotherArray.calcRank()
    if (thisRank != otherRank) {
        return if (thisRank > otherRank) 1 else -1
    }


    val me = this.toMapWithCardValue().toList().sortedByDescending { it.second.toString() + valTableMap[it.first] }
    val other = anotherArray.toMapWithCardValue().toList().sortedByDescending { it.second.toString() + valTableMap[it.first] }
    me.forEachIndexed { i, pair ->
        val meVal = valTableMap[pair.first]
        val otherVal = valTableMap[other[i].first]
        if (meVal != otherVal) {
            if (null == meVal || otherVal == null) {
                return 0
            }
            return if (meVal > otherVal) 1 else -1
        }
    }
    return 0
}

fun Array<String>.countByCardWithIndex(index: Int): Int {
    return this.distinctBy { it[index] }.count()
}

fun Array<String>.countByCardSuit(): Int {
    return this.countByCardWithIndex(1)
}

fun Array<String>.isOnePair(): Boolean {
    return 1 == this.toMapWithCardValue().values.count { it == 2 }
}

fun Array<String>.isTwoPair(): Boolean {
    return 2 == this.toMapWithCardValue().values.count { it == 2 }
}

fun Array<String>.isThreeOfAKind(): Boolean {
    return 1 == this.toMapWithCardValue().values.count { it == 3 }
}

fun Array<String>.isStraight(): Boolean {
    this.sortByDEcedingCardValue()
            .forEachIndexed { i, s ->
                if (this.lastIndex == i) {
                    return true
                } else {
                    val next = this[i + 1]
                    if (valTableMap[s[0]]?.minus(1) != valTableMap[next[0]]) {
                        return false
                    }
                }
            }
    return true
}

fun Array<String>.isFlush(): Boolean {
    return 1 == this.countByCardSuit()
}

fun Array<String>.isFullHouse(): Boolean {
    return isThreeOfAKind() && isOnePair()
}

fun Array<String>.isFourOfAKind(): Boolean {
    return 1 == this.toMapWithCardValue().values.count { it == 4 }
}

fun Array<String>.isStraightFlush(): Boolean {
    return this.isFlush() && this.isStraight()
}

fun Array<String>.isRoyalFlush(): Boolean {
    val straight = arrayOf('T', 'J', 'Q', 'K', 'A')
    if (5 != this.size) {
        return false
    }
    if (5 != this.count { it[0] in straight }) {
        return false
    }
    if (1 != this.distinctBy { it[1] }.count()) {
        return false
    }
    return true
}

fun Array<String>.calcRank(): Int = when {
    this.isRoyalFlush()    -> 9
    this.isStraightFlush() -> 8
    this.isFourOfAKind()   -> 7
    this.isFullHouse()     -> 6
    this.isFlush()         -> 5
    this.isStraight()      -> 4
    this.isThreeOfAKind()  -> 3
    this.isTwoPair()       -> 2
    this.isOnePair()       -> 1
    else                   -> 0//highCard
}

fun main(args: Array<String>) {
    val list = readData()
    var count = 0
    EulerUtil.start()
    list.forEach {
        val player1 = it[0].sortByDEcedingCardValue()
        val player2 = it[1].sortByDEcedingCardValue()
        if (player1.compareToAnotherPlayer(player2) == 1) {
            count++
        }
    }
    println(count)
    EulerUtil.end()
}