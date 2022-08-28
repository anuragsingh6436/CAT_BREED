package com.example.intuit.base


inline fun <reified T> Any?.executeIfCast(block: T.() -> Unit) {
    if (this is T) {
        block()
    }
}