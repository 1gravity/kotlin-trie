package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieNonRecursiveTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieNonRecursive())
    }

    @Test
    fun testDelete() {
        testDelete(TrieNonRecursive())
    }

}