data class Task(val time: Int, val duration: Int)

fun doWork(list: ArrayList<Task>) {

    val result = ArrayList<Int>()

    var currentTime = 0
    for (task in list) {

        if (currentTime == 0) {
            result.add(task.time + task.duration)
            currentTime = task.time + task.duration
        } else if (currentTime < task.time) {
            result.add(task.time + task.duration)
            currentTime = task.time + task.duration
        } else {
            result.add(currentTime + task.duration)
            currentTime += task.duration
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
        val taskAmount = Integer.parseInt(readLine())

        val arr = ArrayList<Task>()
        for (j in 1 .. taskAmount) {
            val str = readLine()
            arr.add(Task(str!!.split(" ")[0].toInt(), str!!.split(" ")[1].toInt()))
        }

        doWork(arr)
    }
}
