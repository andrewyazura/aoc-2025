package com.andrewyazura.aoc.day08

data class JunctionBox(val x: Int, val y: Int, val z: Int)
typealias Day08Input = List<JunctionBox>

fun parseInputData(rawData: String): Day08Input = rawData.lines().map {
    val (x, y, z) = it.split(",").map { n -> n.toInt() }
    JunctionBox(x, y, z)
}


fun distanceSquared(box1: JunctionBox, box2: JunctionBox): Long =
    listOf((box1.x - box2.x), (box1.y - box2.y), (box1.z - box2.z)).sumOf { it.toLong() * it }

class FlatSpaghettiStack(capacity: Int) {
    val parents = IntArray(capacity) { it }
    val sizes = IntArray(capacity) { 1 }
    var count = capacity

    fun find(x: Int): Int {
        var current = x
        while (parents[current] != current) {
            parents[current] = parents[parents[current]]
            current = parents[current]
        }

        return current
    }

    fun merge(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX == rootY) return

        parents[rootY] = rootX
        sizes[rootX] += sizes[rootY]
        count--
    }
}

fun solvePart1(input: Day08Input, limit: Int = 1000): Long = input.flatMapIndexed { index, _ ->
    (index + 1 until input.size).map { indexInner -> index to indexInner }
}.sortedBy { (fromIndex, toIndex) ->
    distanceSquared(input[fromIndex], input[toIndex])
}.let { pairs ->
    FlatSpaghettiStack(input.size).also { stack ->
        pairs.take(limit).forEach { (box1, box2) ->
            stack.merge(box1, box2)
        }
    }.let { stack ->
        stack.sizes.filterIndexed { index, _ -> stack.parents[index] == index }
            .sortedDescending().take(3).fold(1) { acc, size -> acc * size }
    }
}

fun solvePart2(input: Day08Input): Long = input.indices.flatMap { index ->
    (index + 1 until input.size).map { indexInner -> index to indexInner }
}.sortedBy { (fromIndex, toIndex) ->
    distanceSquared(input[fromIndex], input[toIndex])
}.let { pairs ->
    FlatSpaghettiStack(input.size).let { stack ->
        pairs.first { (box1, box2) ->
            stack.merge(box1, box2)
            stack.count == 1
        }
    }
}.let { (box1, box2) -> input[box1].x.toLong() * input[box2].x }