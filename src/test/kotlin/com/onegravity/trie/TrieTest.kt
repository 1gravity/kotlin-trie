package com.onegravity.trie

import org.junit.jupiter.api.Assertions

abstract class TrieTest {

    private val dictionary = mapOf(
        "ar" to listOf("Ariel", "Ariane"),
        "ari" to listOf("Ariel"),
        "Ari" to listOf("Arinol"),
        "AR" to listOf("Arangar", "Aron"),
        "a" to listOf("Andrea", "Anton"),
        "aaa" to emptyList(),
        "" to listOf("Andrea", "Anton"),
    )

    private val delete = listOf(
        "ar",
        "AR",
        "",
    )

    private val dictionaryDeleted = mapOf(
        "ari" to listOf("Ariel"),
        "Ari" to listOf("Arinol"),
        "a" to listOf("Andrea", "Anton"),
        "aaa" to emptyList(),
    )

    fun testInsert(trie: Trie<List<String>>) {
        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
        }
        dictionary.forEach { (key, value) ->
            Assertions.assertEquals(value, trie.search(key))
        }

        Assertions.assertEquals(null, trie.search("N/A"))
        Assertions.assertEquals(null, trie.search("aaaa"))
    }

    fun testDelete(trie: Trie<List<String>>) {
        testDelete1(trie)
        testDelete2(trie)
        testDelete3(trie)
    }

    private fun testDelete1(trie: Trie<List<String>>) {
        trie.clear()

        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
            Assertions.assertEquals(value, trie.search(key))
        }

        val dictionaryCopy = HashMap<String, List<String>>(dictionary)
        delete.forEach { key ->
            trie.delete(key)
            dictionaryCopy.remove(key)
            dictionaryCopy.forEach { (key, value) ->
                Assertions.assertEquals(value, trie.search(key))
            }
            Assertions.assertEquals(null, trie.search(key))
        }

        dictionaryDeleted.forEach { (key, value) ->
            Assertions.assertEquals(value, trie.search(key))
        }
    }

    private fun testDelete2(trie: Trie<List<String>>) {
        trie.clear()

        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
        }

        val dictionaryCopy = HashMap<String, List<String>>(dictionary)
        trie.delete("ar")
        dictionaryCopy.remove("ar")
        trie.delete("ari")
        dictionaryCopy.remove("ari")

        dictionaryCopy.forEach { (key, value) ->
            Assertions.assertEquals(value, trie.search(key))
        }
    }

    private fun testDelete3(trie: Trie<List<String>>) {
        trie.clear()

        dictionary.forEach { (key, value) ->
            trie.insert(key, value)
        }

        val dictionaryCopy = HashMap<String, List<String>>(dictionary)
        trie.delete("ari")
        dictionaryCopy.remove("ari")
        trie.delete("ar")
        dictionaryCopy.remove("ar")

        trie.delete("N/A")

        dictionaryCopy.forEach { (key, value) ->
            Assertions.assertEquals(value, trie.search(key))
        }
    }
}