package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieImprovedSearchTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieImprovedSearch())
    }

    @Test
    fun testDelete() {
        testDelete(TrieImprovedSearch())
    }

}