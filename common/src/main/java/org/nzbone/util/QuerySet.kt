package org.nzbone.util

import java.util.HashSet

fun <T> querySetOf(vararg values: T): QuerySet<T> {
    return QuerySet<T>().apply {
        addAll(values)
    }
}

fun <T> Set<T>.toQuerySet(): QuerySet<T> {
    return QuerySet<T>().apply {
        addAll(this)
    }
}

class QuerySet<T> : HashSet<T>() {

    override fun toString(): String {
        return this.joinToString(separator = "|") { it.toString() }
    }
}
