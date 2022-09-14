package com.onegravity.trie

open class TrieImprovedInsert<Value> : TrieBasic<Value>() {

    override fun insert(key: String, value: Value) {
        key.fold(root) { node, char ->
            node.children[char] ?: Trie.Node<Value>().also { node.children[char] = it }
        }.value = value
    }

}