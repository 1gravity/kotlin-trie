package com.onegravity.trie

open class TrieImprovedSearch<Value> : TrieImprovedInsert<Value>() {

    override fun search(key: String) =
        key.fold(root) { node, char ->
            node.children[char] ?: return null
        }.value

}