package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieImprovedDeleteTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieImprovedDelete())
    }

    @Test
    fun testDelete() {
        testDelete(TrieImprovedDelete())
    }

}