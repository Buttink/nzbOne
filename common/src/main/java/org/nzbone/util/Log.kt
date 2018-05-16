package org.nzbone.util

interface Log {

    fun e(tag: String, message: String, exception: Exception)
    fun w(tag: String, message: String)
    fun i(tag: String, message: String)
    fun d(tag: String, message: String)
}