package com.onegravity.trie

open class TrieNonRecursive<Value> : TrieOptimized<Value>() {

    override val root = Trie.Node<Value>()

    /**
     * We need to override insert to set the [Trie.Node.parent] property
     */
    override fun insert(key: String, value: Value) {
        key.fold(root) { node, char ->
            (node.children[char] ?: Trie.Node()).also { child ->
                node.children[char] = child
                child.parent = node     // <-- this
            }
        }.value = value
    }

    override fun delete(key: String) {
        // search leaf
        key.fold(root) { node, char ->
            node.children[char] ?: return
        }.let { leaf ->
            leaf.value = null
            key.foldRight(leaf) { char, current ->
                if (current.children.isEmpty() && current.value == null) {
                    current.parent?.apply { children.remove(char) } ?: return
                } else return
            }
        }
    }

}
