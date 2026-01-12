package com.andrewyazura.aoc.day01

import kotlin.math.abs

typealias Day01Input = List<Pair<String, Int>>

fun parseInputData(rawData: String): Day01Input =
    rawData.lineSequence().map { line ->
        line.take(1) to line.drop(1).toInt()
    }.toList()

fun solvePart1(input: Day01Input): Int =
    input.fold((50 to 0)) { acc, (direction, steps) ->
        val change = if (direction == "R") steps else -steps
        val dial = (acc.first + change % 100 + 100) % 100
        val count = acc.second + if (acc.first == 0) 1 else 0
        (dial to count)
    }.second

fun crossesZero(start: Int, end: Int): Int =
    abs(
        when {
            end > start -> (end / 100) - (start / 100)
            end < start -> (start - 1).floorDiv(100) - (end - 1).floorDiv(100)
            else -> 0
        }
    )


fun solvePart2(input: Day01Input): Int =
    input.fold((50 to 0)) { (start, zeros), (direction, steps) ->
        val end = start + (if (direction == "R") steps else -steps)
        val zeros = zeros + crossesZero(start, end)

        val dial = (end % 100 + 100) % 100
        (dial to zeros)
    }.second