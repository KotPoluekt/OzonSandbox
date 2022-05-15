fun doWork_1(array: List<Int>) {
    var result = 0

    val map = HashMap<Int, Int>()

    for (i in array) {
        if (map.contains(i)) {
            val v = map[i]
            if (v != null) {
                map[i] = v + 1
            }
        } else {
            map[i] = 1
        }
    }


    for (i in map.keys) {
        val m = map[i]
        if (m != null) {
            val price = ((m / 3)*2 + (m % 3))*i
            result += price
        }
    }

    println(result)
}


fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine() // ??
        val array = readLine()?.split(" ")?.map { it.toInt()}

        if (array != null) {
            doWork_1(array)
        }
    }
}
