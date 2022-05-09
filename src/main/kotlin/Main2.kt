import java.util.Collections
import java.util.LinkedList
import java.util.TreeMap
import java.util.TreeSet

fun prioritize(tasks: IntArray) {

    val weights = TreeMap<Int, Int>(Collections.reverseOrder())

    for (i in tasks) {
        weights[i] = 0
    }

    var lastIndex = -1
    var calculated = -1
    for (i in weights.keys) {

        if (lastIndex == -1) {
            calculated = 1
            lastIndex = i
            weights[i] = calculated
        } else if (i + 1 == lastIndex) {
            weights[i] = calculated
        } else {
            calculated++
            lastIndex = i
            weights[i] = calculated
        }
    }

    for (i in tasks.indices) {
        tasks[i] = weights[tasks[i]] ?: 0
    }
}

fun main(args: Array<String>) {

    // initialization

    val setAmount = Integer.parseInt(readLine())
    val setList = ArrayList<IntArray>()

    for (i in 1 .. setAmount) {
        val taskAmount = Integer.parseInt(readLine()) // for what??

        val array = readLine()?.split(" ")?.map { it.toInt()}
        //val array = "3 1 4 1 5 9 2 6 5 3 5 8 9".split(" ")?.map { it.toInt()}


        if (array != null) {
            setList.add(array.toIntArray())
        }
    }

    // prioritizing
    for (list in setList) {
        prioritize(list)
    }

    for (subList in setList) {
        if (subList != null) {
            var s = ""
            val builder = StringBuilder()
            subList.map { builder.append("$it ") }
            println(builder.toString().trim())
        }
    }
}
