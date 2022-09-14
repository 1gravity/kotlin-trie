package com.onegravity.trie

class TrieImprovedDelete<Value> : TrieImprovedSearch<Value>() {

    override fun delete(key: String) {
        delete(key, 0, root)
    }

    private fun delete(key: String, index: Int, node: Trie.Node<Value>) {
        if (index == key.length)
            node.value = null
        else node.children[key[index]]?.run {
            delete(key, index + 1, this)
            if (children.isEmpty() && value == null) node.children.remove(key[index])
        }
    }
}
