package com.andrewyazura.aoc.day05

typealias Day05Input = Pair<List<LongRange>, List<Long>>

fun parseInputData(rawInput: String): Day05Input {
    val (rawRanges, rawIds) = rawInput.split("\n\n", limit = 2)

    val ranges = rawRanges.lines().map {
        val (start, end) = it.split("-")
        start.toLong()..end.toLong()
    }

    val ids = rawIds.lines().map(String::toLong)

    return ranges to ids
}

fun mergeRanges(ranges: List<LongRange>): List<LongRange> {
    val sorted = ranges.sortedBy { it.first }
    val mergedRanges = mutableListOf<LongRange>()
    var currentRange = sorted[0]

    for (nextRange in sorted.drop(1)) {
        if (nextRange.first <= (currentRange.last + 1)) {
            currentRange = currentRange.first..maxOf(nextRange.last, currentRange.last)
        } else {
            mergedRanges.add(currentRange)
            currentRange = nextRange
        }
    }

    mergedRanges.add(currentRange)
    return mergedRanges
}

fun solvePart1(input: Day05Input): Int {
    val ranges = mergeRanges(input.first)
    var total = 0

    input.second.forEach {
        for (range in ranges) {
            if (it in range) {
                total++
                break
            }
        }
    }

    return total
}

fun solvePart2(input: Day05Input): Long =
    mergeRanges(input.first).sumOf { it.last - it.first + 1 }