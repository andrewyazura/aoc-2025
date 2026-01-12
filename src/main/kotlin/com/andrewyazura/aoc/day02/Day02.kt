package com.andrewyazura.aoc.day02

typealias Day02Input = List<Pair<Long, Long>>

fun parseInputData(rawData: String): Day02Input =
    rawData.split(",").map { range ->
        val (start, end) = range.split("-")
        start.toLong() to end.toLong()
    }.toList()

fun isInvalidId(id: Long): Boolean {
    val id = id.toString()
    if (id.length % 2 != 0) return false
    return id.startsWith(id.substring(id.length / 2))
}

fun solvePart1(input: Day02Input): Long =
    input.fold(0L) { acc, (start, end) ->
        var sum: Long = 0
        for (i: Long in start..end) {
            if (isInvalidId(i)) sum += i
        }
        acc + sum
    }

val pattern = Regex("""^(\d+)\1+$""")
fun solvePart2(input: Day02Input): Long =
    input.fold(0L) { acc, (start, end) ->
        var sum: Long = 0
        for (i: Long in start..end) {
            if (pattern.containsMatchIn(i.toString())) sum += i
        }
        acc + sum
    }