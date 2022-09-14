package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieBasicTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieBasic())
    }

    @Test
    fun testDelete() {
        testDelete(TrieBasic())
    }

}