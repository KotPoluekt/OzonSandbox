import java.util.LinkedList

fun prioritize(tasks: IntArray) {

    var calculated = 1
    do {

        var maxPriority = 0

        tasks?.map { if (-it > maxPriority && it < 0) maxPriority = -it }

        if (maxPriority == 0) {
            // done
        } else {
            if (tasks != null) {
                for (i in tasks.indices) {
                    if (tasks[i] < 0 && -tasks[i] >= (maxPriority-1) ) tasks[i] = calculated
                }
            }
            //tasks?.map { if (it < 0 && -it >= (maxPriority-1) ) calculated }
            calculated++
        }

    } while (maxPriority > 0)
}

fun main(args: Array<String>) {

    // initialization

    val setAmount = Integer.parseInt(readLine())
    val setList = ArrayList<IntArray>()

    for (i in 1 .. setAmount) {
        val taskAmount = Integer.parseInt(readLine()) // for what??

        val array = readLine()?.split(" ")?.map { -it.toInt()}

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
