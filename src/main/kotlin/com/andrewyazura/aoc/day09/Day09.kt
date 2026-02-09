package com.andrewyazura.aoc.day09

import kotlin.math.abs


data class Point(val x: Long, val y: Long)
typealias Day09Input = List<Point>

fun parseInputData(rawData: String): Day09Input =
    rawData.lines().map {
        val (a, b) = it.split(",")
        Point(a.toLong(), b.toLong())
    }

fun area(point1: Point, point2: Point): Long = (abs(point1.x - point2.x) + 1) * (abs(point1.y - point2.y) + 1)

fun solvePart1(input: Day09Input): Long = input.flatMapIndexed { index, tile ->
    input.drop(index + 1).map { innerTile ->
        area(tile, innerTile)
    }
}.max()

fun compactCoords(set: Iterable<Long>): Map<Long, Long> =
    set.distinct().sorted().withIndex().associate { it.value to it.index.toLong() }

fun getLine(p1: Point, p2: Point): List<Point> {
    val xRange = if (p1.x <= p2.x) p1.x..p2.x else p2.x..p1.x
    val yRange = if (p1.y <= p2.y) p1.y..p2.y else p2.y..p1.y

    return xRange.flatMap { x ->
        yRange.map { y ->
            Point(x, y)
        }
    }
}

fun solvePart2(input: Day09Input): Long {
    val compactedX = compactCoords(input.map { it.x }.toSet())
    val compactedY = compactCoords(input.map { it.y }.toSet())

    val borders = input.zipWithNext().flatMap { (p1, p2) ->
        val c1 = Point(compactedX.getValue(p1.x), compactedY.getValue(p1.y))
        val c2 = Point(compactedX.getValue(p2.x), compactedY.getValue(p2.y))

        getLine(c1, c2)
    }.toSet()

    val matrix: Array<Array<Boolean>> = Array(compactedY.size) { y ->
        Array(compactedX.size) { x ->
            Point(x.toLong(), y.toLong()) in borders
        }
    }

    matrix.forEach { row ->
        row.forEach { col -> print(if (col) "#" else ".") }
        println()
    }

    return 10L
}