package com.onegravity.trie

import org.jetbrains.annotations.TestOnly

interface Trie<Value> {

    val root: Node<Value>

    data class Node<Value>(
        var parent: Node<Value>? = null,    // only used for the non-recursive delete operation
        val children: MutableMap<Char, Node<Value>> = mutableMapOf(),
        var value: Value? = null,
    ) {
        @TestOnly
        internal fun clear() {
            children.clear()
            value = null
        }
    }

    fun insert(key: String, value: Value)

    fun search(key: String): Value?

    fun delete(key: String)

    /**
     * In tests we want to re-use the Trie.
     */
    @TestOnly
    fun clear() {
        root.clear()
    }

}