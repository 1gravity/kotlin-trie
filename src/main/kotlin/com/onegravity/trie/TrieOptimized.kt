package com.onegravity.trie

/**
 * TODO add a startsWith function
 * TODO implement a non-recursive delete function
 */
open class TrieOptimized<Value> : Trie<Value> {

    override val root = Trie.Node<Value>()

    override fun insert(key: String, value: Value) {
        key.fold(root) { node, char ->
            (node.children[char] ?: Trie.Node()).also { node.children[char] = it }
        }.value = value
    }

    override fun search(key: String) =
        key.fold(root) { node, char ->
            node.children[char] ?: return null
        }.value

    override fun delete(key: String) {
        delete(key, 0, root)
    }

    private fun delete(key: String, index: Int, node: Trie.Node<Value>) {
        if (index == key.length)
            node.value = null
        else node.children[key[index]]?.let { child ->
            delete(key, index + 1, child)
            if (node.children.isEmpty() && node.value == null) node.children.remove(key[index])
        }
    }

}