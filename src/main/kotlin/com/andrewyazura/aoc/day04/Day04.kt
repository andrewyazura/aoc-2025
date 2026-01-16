package com.andrewyazura.aoc.day04

typealias Day04Input = List<String>

fun parseInputData(rawInput: String): Day04Input = rawInput.lines()

fun Day04Input.getSurrounding(rowIndex: Int, columnIndex: Int): List<Char> = listOf(
    Pair(-1, -1),
    Pair(-1, 0),
    Pair(-1, 1),

    Pair(0, -1),
    Pair(0, 1),

    Pair(1, -1),
    Pair(1, 0),
    Pair(1, 1),
).map {
    it.first + rowIndex to it.second + columnIndex
}.filter { (rowIndex, colIndex) ->
    rowIndex in 0..<this.size && colIndex in 0..<this[0].length
}.map {
    this[it.first][it.second]
}

fun solvePart1(input: Day04Input): Int = input.foldIndexed(0) { rowIndex, totalAcc, row ->
    totalAcc + row.foldIndexed(0) { columnIndex, rowAcc, char ->
        if (char != '@') rowAcc else (if (input.getSurrounding(rowIndex, columnIndex).filter { it == '@' }
                .sumOf { 1 } < 4) rowAcc + 1 else rowAcc)
    }
}

fun solvePart2(input: Day04Input): Int {
    var total = 0
    val mutInput = input.toMutableList()

    do {
        val toRemove = mutableListOf<Pair<Int, Int>>()

        mutInput.forEachIndexed { rowIndex, row ->
            row.forEachIndexed inner@{ columnIndex, char ->
                if (char != '@') return@inner

                val rolls = mutInput.getSurrounding(rowIndex, columnIndex).filter { it == '@' }.sumOf { 1 }
                if (rolls >= 4) return@inner

                toRemove.add(rowIndex to columnIndex)
            }
        }

        toRemove.forEach { (r, c) ->
            val rowBuilder = StringBuilder(mutInput[r])
            rowBuilder.setCharAt(c, '.')
            mutInput[r] = rowBuilder.toString()
        }

        total += toRemove.size
    } while (toRemove.isNotEmpty())

    return total
}