package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieOptimizedTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieOptimized())
    }

    @Test
    fun testDelete() {
        testDelete(TrieOptimized())
    }

}