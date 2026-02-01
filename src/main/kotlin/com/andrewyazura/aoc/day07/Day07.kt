package com.andrewyazura.aoc.day07

typealias Manifold = List<Set<Int>>
typealias Day07Input = Pair<Int, Manifold>

fun parseInputData(rawInput: String): Day07Input =
    rawInput.lines().first().indexOf('S') to rawInput.lines().drop(1)
        .map { it.mapIndexedNotNull { index, ch -> if (ch == '^') index else null }.toSet() }

fun solvePart1(input: Day07Input): Int {
    var beams = mutableSetOf(input.first)
    var total = 0

    input.second.forEach { row ->
        val tmp = mutableSetOf<Int>()

        beams.forEach { beam ->
            if (beam in row) {
                total++
                tmp.add(beam - 1)
                tmp.add(beam + 1)
            } else {
                tmp.add(beam)
            }
        }

        beams = tmp
    }

    return total
}

fun solvePart2(input: Day07Input): Long {
    return countTimelines(input.second, 0, input.first)
}

val cache = mutableMapOf<Pair<Int, Int>, Long>()

fun countTimelines(manifold: Manifold, row: Int, index: Int): Long {
    if (cache.containsKey(row to index)) return cache.getValue(row to index)

    if (row == manifold.size) {
        return 1
    }

    if (index in manifold[row]) {
        val left = countTimelines(manifold, row + 1, index - 1)
        val right = countTimelines(manifold, row + 1, index + 1)
        val result = left + right

        cache[row to index] = result
        return result
    }

    val result = countTimelines(manifold, row + 1, index)
    cache[row to index] = result
    return result
}