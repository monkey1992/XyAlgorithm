package com.xy.algorithm

class KuoZhan {

    var name: String? = null

    fun String.abc(): String {
        return "$this abc"
    }
}

fun KuoZhan.abc(): KuoZhan {
    this.name = "abc"
    return this
}