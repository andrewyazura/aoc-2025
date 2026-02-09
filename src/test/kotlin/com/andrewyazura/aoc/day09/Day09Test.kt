package com.andrewyazura.aoc.day09

import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {
    val testData = """
        7,1
        11,1
        11,7
        9,7
        9,5
        2,5
        2,3
        7,3
    """.trimIndent()

    @Test
    fun part1TestData() {
        val maxArea = solvePart1(parseInputData(testData))
        assertEquals(50, maxArea)
    }

    @Test
    fun part1Answer() {
        val maxArea = solvePart1(parseInputData(day09Input))
        println(maxArea)
    }

//    @Test
//    fun testCompactCoords() {
//        val points = parseInputData(testData)
//
//        val compactedX = compactCoords(points.map { it.x }.toSet())
//        val compactedY = compactCoords(points.map { it.y }.toSet())
//
//        assertEquals(
//            mapOf(
//                0L to 0L,
//                1L to 0L,
//                2L to 1L,
//                3L to 2L,
//                4L to 2L,
//                5L to 2L,
//                6L to 2L,
//                7L to 3L,
//                8L to 4L,
//                9L to 5L,
//                10L to 6L,
//                11L to 7L,
//            ),
//            compactedX
//        )
//
//        assertEquals(
//            mapOf(
//                0L to 0L,
//                1L to 1L,
//                2L to 2L,
//                3L to 3L,
//                4L to 4L,
//                5L to 5L,
//                6L to 6L,
//                7L to 7L,
//            ),
//            compactedY
//        )
//    }

    @Test
    fun testCompactCoords() {
        val points = parseInputData(testData)

        val compactedX = compactCoords(points.map { it.x }.toSet())
        val compactedY = compactCoords(points.map { it.y }.toSet())

        assertEquals(
            mapOf(
                2L to 0L,
                7L to 1L,
                9L to 2L,
                11L to 3L,
            ),
            compactedX
        )

        assertEquals(
            mapOf(
                1L to 0L,
                3L to 1L,
                5L to 2L,
                7L to 3L,
            ),
            compactedY
        )
    }

    @Test
    fun testGetLine() {
        assertEquals(
            listOf(
                Point(0, 0),
                Point(0, 1),
                Point(0, 2),
                Point(0, 3),
                Point(0, 4),
            ),
            getLine(
                Point(0, 0),
                Point(0, 4),
            )
        )

        assertEquals(
            listOf(
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
                Point(3, 0),
                Point(4, 0),
            ),
            getLine(
                Point(0, 0),
                Point(4, 0),
            )
        )
    }

    @Test
    fun part2TestData() {
        val maxArea = solvePart2(parseInputData(testData))
        assertEquals(24, maxArea)
    }

    @Test
    fun part2Answer() {
        val maxArea = solvePart2(parseInputData(day09Input))
        println(maxArea)
    }
}