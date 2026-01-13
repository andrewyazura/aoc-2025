package com.andrewyazura.aoc.day03

import java.util.Stack

typealias Day03Input = List<String>

fun parseInputData(rawInput: String): Day03Input = rawInput.lines()

fun maxTwoDigitJoltage(s: String): Int {
    val firstMaxIndex = s.indices.toList().dropLast(1).maxBy { s[it].digitToInt() }
    val secondMax = s.substring(firstMaxIndex + 1).maxBy { it.digitToInt() }

    return s[firstMaxIndex].digitToInt() * 10 + secondMax.digitToInt()
}

fun maxTwoDigitJoltageInv(s: String): Int {
    var maxTotal = 0
    var maxRight: Int = -1

    s.reversed().map(Char::digitToInt).forEach { digit ->
        if (maxRight != -1)
            maxTotal = maxOf(maxTotal, digit * 10 + maxRight)

        maxRight = maxOf(maxRight, digit)
    }

    return maxTotal
}

fun solvePart1(input: Day03Input): Int =
    input.sumOf { battery -> maxTwoDigitJoltageInv(battery) }

fun maxJoltageRecursive(s: String, n: Int = 12): Long {
    return maxJoltageRecursiveInternal(s, n).toLong()
}

private fun maxJoltageRecursiveInternal(s: String, n: Int = 12): String {
    if (n == 0) return ""
    val firstMaxIndex = s.indices.toList().dropLast(n - 1).maxBy { s[it].digitToInt() }
    return s[firstMaxIndex] + maxJoltageRecursiveInternal(s.substring(firstMaxIndex + 1), n - 1)
}

fun maxJoltageStack(s: String, n: Int = 12): Long {
    val stack = Stack<Char>()
    var skipsAvailable = s.length - n

    for (c in s) {
        while (stack.isNotEmpty() && c > stack.peek() && skipsAvailable >= 1) {
            stack.pop()
            skipsAvailable--
        }

        if (stack.size < n) {
            stack.push(c)
        } else {
            skipsAvailable--
        }
    }

    return stack.joinToString("").toLong()
}

fun solvePart2(input: Day03Input): Long =
    input.sumOf { battery -> maxJoltageStack(battery, 12) }