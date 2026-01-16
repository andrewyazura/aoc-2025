package com.andrewyazura.aoc.day04

import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
    val testData = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent()

    @Test
    fun testGetSurrounding() {
        val input = parseInputData(testData)
        assertEquals(listOf('.', '@', '@', '@', '.'), input.getSurrounding(0, 2))
    }

    @Test
    fun part1TestData() {
        val rolls = solvePart1(parseInputData(testData))
        assertEquals(13, rolls)
    }

    @Test
    fun part1Answer() {
        val rolls = solvePart1(parseInputData(day04Input))
        println(rolls)
    }

    @Test
    fun part2TestData() {
        val rolls = solvePart2(parseInputData(testData))
        assertEquals(43, rolls)
    }

    @Test
    fun part2Answer() {
        val rolls = solvePart2(parseInputData(day04Input))
        println(rolls)
    }
}