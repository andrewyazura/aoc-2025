package com.andrewyazura.aoc.day05

import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
    val testData = """
        3-5
        10-14
        16-20
        12-18

        1
        5
        8
        11
        17
        32
    """.trimIndent()

    @Test
    fun testMergeRanges() {
        val ranges = listOf(
            1L..10L,
            9L..12L,
            13L..20L,
            25L..40L,
            45L..50L,
            51L..69L,
            52L..53L,
            54L..55L,
        )
        val expectedRanges = listOf(
            1L..20L,
            25L..40L,
            45L..69L,
        )

        assertEquals(expectedRanges, mergeRanges(ranges))
    }

    @Test
    fun part1TestData() {
        val ids = solvePart1(parseInputData(testData))
        assertEquals(3, ids)
    }

    @Test
    fun part1Answer() {
        val ids = solvePart1(parseInputData(day05Input))
        println(ids)
    }

    @Test
    fun part2TestData() {
        val ids = solvePart2(parseInputData(testData))
        assertEquals(14, ids)
    }

    @Test
    fun part2Answer() {
        val ids = solvePart2(parseInputData(day05Input))
        println(ids)
    }
}