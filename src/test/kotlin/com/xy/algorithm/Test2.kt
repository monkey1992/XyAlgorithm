package com.xy.algorithm

import org.junit.Test

class Test2 {

    @Test
    fun testIntRange() {
        val max = 1
        val range = (0 until max)
//        val range = listOf(0, 1, 2, 3, 4)
        for (i in range) {
            println(i)
        }
        val test2 = Test2()
        println(test2::class.java.name == test2.javaClass.name)
    }
}