package com.andrewyazura.aoc.day06


typealias Day06Input = List<Pair<Char, List<String>>>

fun parseInputData(rawInput: String): Day06Input =
    "[*+]\\s+(?=(?:\\s[*+])|\$)".toRegex().findAll(rawInput.lines().last()).map {
        val colRange = it.groups.first()!!.range
        val sign = it.groups.first()!!.value.first()

        sign to rawInput.lines().dropLast(1).map { line ->
            line.substring(colRange)
        }
    }.toList()

fun solvePart1(input: Day06Input): Long = input.sumOf { (sign, numbers) ->
    when (sign) {
        '+' -> numbers.sumOf { it.trim().toLong() }
        '*' -> numbers.fold(1) { acc, i -> acc * i.trim().toLong() }
        else -> throw Exception()
    }
}

fun solvePart2(input: Day06Input): Long =
    input.sumOf { (sign, numbers) ->
        val newNumbers = (0 until numbers[0].length).map {
            numbers.map { num ->
                num[it]
            }.filter { num -> !num.isWhitespace() }.joinToString("").toLong()
        }

        when (sign) {
            '+' -> newNumbers.sum()
            '*' -> newNumbers.fold(1L) { acc, i -> acc * i }
            else -> throw Exception()
        }
    }