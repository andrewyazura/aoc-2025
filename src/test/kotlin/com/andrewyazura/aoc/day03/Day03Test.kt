package com.andrewyazura.aoc.day03

import kotlin.test.Test
import kotlin.test.assertEquals


class Day03Test {
    val testData = """
        987654321111111
        811111111111119
        234234234234278
        818181911112111
    """.trimIndent()

    @Test
    fun testMaxTwoDigitJoltage() {
        assertEquals(99, maxTwoDigitJoltage("99"))
        assertEquals(89, maxTwoDigitJoltage("811111111111119"))
        assertEquals(92, maxTwoDigitJoltage("818181911112111"))
    }

    @Test
    fun testMaxTwoDigitJoltageInv() {
        assertEquals(99, maxTwoDigitJoltageInv("99"))
        assertEquals(89, maxTwoDigitJoltageInv("811111111111119"))
        assertEquals(92, maxTwoDigitJoltageInv("818181911112111"))
    }

    @Test
    fun part1TestData() {
        val joltage = solvePart1(parseInputData(testData))
        assertEquals(357, joltage)
    }

    @Test
    fun part1Answer() {
        val joltage = solvePart1(parseInputData(day03Input))
        println("part1: $joltage")
    }

    @Test
    fun testMaxJoltageRecursive() {
        assertEquals(987654321111, maxJoltageRecursive("987654321111111"))
        assertEquals(811111111119, maxJoltageRecursive("811111111111119"))
        assertEquals(434234234278, maxJoltageRecursive("234234234234278"))
        assertEquals(888911112111, maxJoltageRecursive("818181911112111"))

        assertEquals(99, maxJoltageRecursive("99", 2))
        assertEquals(89, maxJoltageRecursive("811111111111119", 2))
        assertEquals(92, maxJoltageRecursive("818181911112111", 2))
    }

    @Test
    fun testMaxJoltageStack() {
        assertEquals(987654321111, maxJoltageStack("987654321111111"))
        assertEquals(811111111119, maxJoltageStack("811111111111119"))
        assertEquals(434234234278, maxJoltageStack("234234234234278"))
        assertEquals(888911112111, maxJoltageStack("818181911112111"))

        assertEquals(99, maxJoltageStack("99", 2))
        assertEquals(89, maxJoltageStack("811111111111119", 2))
        assertEquals(92, maxJoltageStack("818181911112111", 2))
    }

    @Test
    fun part2TestData() {
        val joltage = solvePart2(parseInputData(testData))
        assertEquals(3121910778619, joltage)
    }

    @Test
    fun part2Answer() {
        val joltage = solvePart2(parseInputData(day03Input))
        println("part2: $joltage")
    }
}