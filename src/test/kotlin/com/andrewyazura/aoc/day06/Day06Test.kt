package com.andrewyazura.aoc.day06

import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {
    val testData = """
        123 328  51 64 
         45 64  387 23 
          6 98  215 314
        *   +   *   +  
    """.trimIndent()

    @Test
    fun testParseData() {
        val tasks = parseInputData(testData)
        assertEquals(
            listOf(
                '*' to listOf("123", " 45", "  6"),
                '+' to listOf("328", "64 ", "98 "),
                '*' to listOf(" 51", "387", "215"),
                '+' to listOf("64 ", "23 ", "314"),
            ), tasks
        )
    }

    @Test
    fun part1TestData() {
        val grandTotal = solvePart1(parseInputData(testData))
        assertEquals(4277556L, grandTotal)
    }

    @Test
    fun part1Answer() {
        val grandTotal = solvePart1(parseInputData(day06Input))
        println(grandTotal)
    }

    @Test
    fun part2TestData() {
        val grandTotal = solvePart2(parseInputData(testData))
        assertEquals(3263827, grandTotal)
    }

    @Test
    fun part2Answer() {
        val grandTotal = solvePart2(parseInputData(day06Input))
        println(grandTotal)
    }
}