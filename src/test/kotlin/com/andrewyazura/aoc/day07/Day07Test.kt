package com.andrewyazura.aoc.day07

import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
    val testData = """
        .......S.......
        ...............
        .......^.......
        ...............
        ......^.^......
        ...............
        .....^.^.^.....
        ...............
        ....^.^...^....
        ...............
        ...^.^...^.^...
        ...............
        ..^...^.....^..
        ...............
        .^.^.^.^.^...^.
        ...............
    """.trimIndent()

    @Test
    fun testParseData() {
        val expected = (7 to listOf<Set<Int>>(
            setOf(),
            setOf(7),
            setOf(),
            setOf(6, 8),
            setOf(),
            setOf(5, 7, 9),
            setOf(),
            setOf(4, 6, 10),
            setOf(),
            setOf(3, 5, 9, 11),
            setOf(),
            setOf(2, 6, 12),
            setOf(),
            setOf(1, 3, 5, 7, 9, 13),
            setOf(),
        ))

        assertEquals(expected, parseInputData(testData))
    }

    @Test
    fun part1TestData() {
        val splits = solvePart1(parseInputData(testData))
        assertEquals(21, splits)
    }

    @Test
    fun part1Answer() {
        val splits = solvePart1(parseInputData(day07Input))
        println(splits)
    }

    @Test
    fun part2TestData() {
        val splits = solvePart2(parseInputData(testData))
        assertEquals(40, splits)
    }

    @Test
    fun part2Answer() {
        val splits = solvePart2(parseInputData(day07Input))
        println(splits)
    }
}