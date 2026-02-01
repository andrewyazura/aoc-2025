package com.andrewyazura.aoc.day08

import kotlin.test.Test
import kotlin.test.assertEquals

class Day08Test {
    val testData = """
        162,817,812
        57,618,57
        906,360,560
        592,479,940
        352,342,300
        466,668,158
        542,29,236
        431,825,988
        739,650,466
        52,470,668
        216,146,977
        819,987,18
        117,168,530
        805,96,715
        346,949,466
        970,615,88
        941,993,340
        862,61,35
        984,92,344
        425,690,689
    """.trimIndent()

    @Test
    fun testParseData() {
        val expected = listOf(
            JunctionBox(x = 162, y = 817, z = 812),
            JunctionBox(x = 57, y = 618, z = 57),
            JunctionBox(x = 906, y = 360, z = 560),
            JunctionBox(x = 592, y = 479, z = 940),
            JunctionBox(x = 352, y = 342, z = 300),
            JunctionBox(x = 466, y = 668, z = 158),
            JunctionBox(x = 542, y = 29, z = 236),
            JunctionBox(x = 431, y = 825, z = 988),
            JunctionBox(x = 739, y = 650, z = 466),
            JunctionBox(x = 52, y = 470, z = 668),
            JunctionBox(x = 216, y = 146, z = 977),
            JunctionBox(x = 819, y = 987, z = 18),
            JunctionBox(x = 117, y = 168, z = 530),
            JunctionBox(x = 805, y = 96, z = 715),
            JunctionBox(x = 346, y = 949, z = 466),
            JunctionBox(x = 970, y = 615, z = 88),
            JunctionBox(x = 941, y = 993, z = 340),
            JunctionBox(x = 862, y = 61, z = 35),
            JunctionBox(x = 984, y = 92, z = 344),
            JunctionBox(x = 425, y = 690, z = 689)
        )

        assertEquals(expected, parseInputData(testData))
    }

    @Test
    fun testDistanceSquared() {
        assertEquals(
            1, distanceSquared(
                JunctionBox(0, 0, 0),
                JunctionBox(1, 0, 0)
            )
        )
    }

    @Test
    fun part1TestData() {
        val circuitsProduct = solvePart1(parseInputData(testData), limit = 10)
        assertEquals(40, circuitsProduct)
    }

    @Test
    fun part1Answer() {
        val circuitsProduct = solvePart1(parseInputData(day08Input))
        println(circuitsProduct)
    }

    @Test
    fun part2TestData() {
        val circuitsProduct = solvePart2(parseInputData(testData))
        assertEquals(25272, circuitsProduct)
    }

    @Test
    fun part2Answer() {
        val circuitsProduct = solvePart2(parseInputData(day08Input))
        println(circuitsProduct)
    }
}