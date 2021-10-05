package com.xy.algorithm

import org.junit.Test
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * 算法复杂度
 */
class Complexity {

    /**
     * 算法复杂度示例-O(n²)
     */
    @Test
    fun complexityNSquare() {
        val n = 10
        val array = arrayOfNulls<IntArray>(n)
        for (i in 0 until n) {
            val arrayJ = IntArray(n)
            array[i] = arrayJ
            for (j in 0 until n) {
                arrayJ[j] = i * j
                println("array[$i][$j]=${array[i]!![j]}")
            }
        }
    }

    /**
     * 算法复杂度示例-O(n²)
     */
    @Test
    fun complexityNSquare2() {
        val n = 10
        println("=========九九乘法口诀表=========")
        for (i in 1 until n) {
            for (j in 1 until n) {
                if (j > i || i == 9) {
                    println()
                    break
                }
                print("$j * $i = ${i * j}   ")
            }
        }
        println("=========九九乘法口诀表=========")
    }

    /**
     * 算法复杂度示例-O(logn)
     * 数字n转换为二进制数
     */
    @Test
    fun complexityLogN() {
        println("=========算法复杂度示例-O(logn)=========")
        var n = 1000
        var s = ""
        while (n > 0) {
            s = (n % 2).toString() + s
            n /= 2
            println("n=$n")
        }
        println("s = $s")
        println("=========算法复杂度示例-O(logn)=========")
    }

    /**
     * 算法复杂度示例-O(1)
     * 判断数字n是否是偶数
     */
    @Test
    fun complexity1() {
        val n = 1024
        assert(n % 2 == 0)
    }

    /**
     * 算法复杂度示例-O(n)
     * 求数字n的所有约数
     */
    @Test
    fun complexityN() {
        val n = 1025
        val list = mutableListOf<Int>()
        for (i in 1..n) {
            if (n % i == 0) {
                list.add(i)
            }
        }
        println("list is $list")
    }

    /**
     * 算法复杂度示例-O(√n）
     * 求数字n的所有约数
     */
    @Test
    fun complexitySqrtN() {
        val n = 1024
        val list = mutableListOf<Int>()
        for (i in 1..sqrt(n.toFloat()).toInt()) {
            if (n % i == 0) {
                list.add(i)
                list.add(n / i)
            }
        }
        println("list is $list")
    }

    /**
     * 算法复杂度示例-O(2^n)
     * n个位数长度的所有二进制数
     */
    @Test
    fun complexitySquareN() {

        fun getB(x: Int, length: Int): String {
            var n = x
            var s = ""
            if (n > 0) {
                while (n > 0) {
                    s = (n % 2).toString() + s
                    n /= 2
                }
            } else {
                s = 0.toString()
            }
            val sLength = s.length
            val lengthDiff = length - sLength
            if (lengthDiff > 0) {
                for (i in 0 until lengthDiff) {
                    s = "0$s"
                }
            }
            return s
        }

        val n = 3
        val list = mutableListOf<String>()
        for (i in 0 until 2.toDouble().pow(n.toDouble()).toInt()) {
            list.add(getB(i, 3))
        }
        println("list is $list")
    }

    /**
     * 算法复杂度示例-O(n!)
     * 求元素个数为n的数组的所有排列
     */
    @Test
    fun complexitySquareNFactorial() {
        val array = arrayOf(8, 6, 12, 969, 67, 39)
        val size = array.size

        data class Node(
            val loopLayerIndex: Int,
            val arrayItem: Int
        )

        for (i in 0..size) {
            for (j in 0..size) {
                if (j == i) {
                    continue
                }
                for (k in 0..size) {
                    if (k == i || k == j) {
                        continue
                    }
                    for (l in 0..size) {
                        if (l == i || l == j || l == k) {
                            continue
                        }



                    }
                }
            }
        }

        val nodeArrays = emptyArray<Array<Node>>()

        val nodeArray = Array(size) { Node(-1, -1) }
        fun getFactorial(loopLayerIndex: Int) {
            for (i in 0..size) {
                nodeArray[i] = Node(loopLayerIndex, array[i])
            }
        }
        getFactorial(0)
    }
}