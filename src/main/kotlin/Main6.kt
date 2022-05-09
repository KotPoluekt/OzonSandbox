import java.util.TreeSet
import kotlin.random.Random

data class Task2(val time: Int, val duration: Int)

class Task3: Comparable<Task3> {
    var time: Int
    var unique: Int

    constructor(time: Int) {
        this.time = time
        this.unique = Random.nextInt()
    }

    override fun compareTo(other: Task3): Int {
        return if (this.time > other.time) 1 else -1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task3

        if (time != other.time) return false
        if (unique != other.unique) return false

        return true
    }

    override fun hashCode(): Int {
        var result = time
        result = 31 * result + unique
        return result
    }


}

fun doWork2(list: ArrayList<Task2>, threadAmount: Int) {

    val result = ArrayList<Int>()
    val threads = TreeSet<Task3>()

    for (task in list) {

        if (threads.size < threadAmount) {
            result.add(task.time + task.duration)
            threads.add(Task3(task.time + task.duration))
        } else {
            val min = threads.pollFirst()

            if (min.time < task.time) {
                result.add(task.time + task.duration)
                threads.add(Task3(task.time + task.duration))
            } else {
                result.add(min.time + task.duration)
                threads.add(Task3(min.time + task.duration))
            }

        }
    }

    val builder = StringBuilder()
    result.map { builder.append("$it ") }
    println(builder.toString().trim())
}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine()
        val s = readLine()
        val threadAmount = Integer.parseInt(s!!.split(" ")[0])
        val taskAmount = Integer.parseInt(s!!.split(" ")[1])

        val arr = ArrayList<Task2>()
        for (j in 1 .. taskAmount) {
            val str = readLine()
            arr.add(Task2(str!!.split(" ")[0].toInt(), str!!.split(" ")[1].toInt()))
        }

        doWork2(arr, threadAmount)
    }
}
