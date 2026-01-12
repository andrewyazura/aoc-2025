package com.andrewyazura.aoc.day02

import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    val testData =
        "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"

    @Test
    fun testInvalidIds() {
        val validIds = listOf(1L, 101L)
        val invalidIds = listOf(11L, 22L, 1188511885L, 38593859L, 446446L)

        validIds.forEach { id ->
            assertEquals(false, isInvalidId(id), "ID $id should be VALID")
        }

        invalidIds.forEach { id ->
            assertEquals(true, isInvalidId(id), "ID $id should be INVALID")
        }
    }

    @Test
    fun part1TestData() {
        val sum = solvePart1(parseInputData(testData))
        assertEquals(1227775554, sum)
    }

    @Test
    fun part1Answer() {
        val sum = solvePart1(parseInputData(day02Input))
        println("part1: $sum")
    }

    @Test
    fun part2TestData() {
        val sum = solvePart2(parseInputData(testData))
        assertEquals(4174379265, sum)
    }

    @Test
    fun part2Answer() {
        val sum = solvePart2(parseInputData(day02Input))
        println("part2: $sum")
    }
}