package com.onegravity.trie

import org.junit.jupiter.api.Test

class TrieImprovedInsertTest : TrieTest() {

    @Test
    fun testInsert() {
        testInsert(TrieImprovedInsert())
    }

    @Test
    fun testDelete() {
        testDelete(TrieImprovedInsert())
    }

}