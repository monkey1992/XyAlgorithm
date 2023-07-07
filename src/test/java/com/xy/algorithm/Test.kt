package com.xy.algorithm

class Test {

    @org.junit.Test
    fun test() {
//        val list = listOf<Any?>()
        val list: List<Any?>? = null
        assert(list?.contains(null) == null)
    }
}