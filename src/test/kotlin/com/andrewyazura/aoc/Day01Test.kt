package com.andrewyazura.aoc

import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    val testData = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()

    @Test
    fun part1TestData() {
        val password = solvePart1(parseInputData(testData))
        assertEquals(3, password)
    }

    @Test
    fun part1Answer() {
        val password = solvePart1(parseInputData(day01Input))
        println("part1: $password")
    }

    @Test
    fun crossesZeroPositive() {
        assertEquals(1, crossesZero(50, 150))
        assertEquals(2, crossesZero(50, 200))
        assertEquals(9, crossesZero(50, 999))

        assertEquals(1, crossesZero(50, 100))
    }

    @Test
    fun crossesZeroNegative() {
        assertEquals(1, crossesZero(50, -18))
        assertEquals(2, crossesZero(50, -100))
        assertEquals(9, crossesZero(50, -899))

        assertEquals(1, crossesZero(50, 0))
    }

    @Test
    fun part2TestData() {
        val password = solvePart2(parseInputData(testData))
        assertEquals(6, password)
    }

    @Test
    fun part2Answer() {
        val password = solvePart2(parseInputData(day01Input))
        println("part2: $password")
    }
}