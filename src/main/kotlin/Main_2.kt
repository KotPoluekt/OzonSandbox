fun doWork_2(table: Array<Array<Int>>, clicks: List<Int>, rows: Int, cols: Int) {

    for (click in clicks) {

        var sorted = false
        while (!sorted) {

            sorted = true
            for (i in 1 until rows) {
                val previous = table[i - 1][click-1]
                val current = table[i][click-1]
                if (previous > current) {

                    for (j in 0 until cols) {
                        val temp = table[i-1][j]
                        table[i-1][j] = table[i][j]
                        table[i][j] = temp
                    }
                    sorted = false
                }
            }

        }
    }


    for (i in 0 until rows) {
        var s = ""
        for (j in 0 until cols) {
            s += "${table[i][j]} "
        }
        println(s.trim())
    }


    println()
}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine() // ??

        val ss = readLine()
        val rows = Integer.parseInt(ss!!.split(" ")[0])
        val cols = Integer.parseInt(ss!!.split(" ")[1])

        val table: Array<Array<Int>> = Array(rows) { Array(cols) { 0 } }

        for (j in 0 until rows) {
            val s = readLine()

            val arr = s!!.split(" ")?.map { it.toInt()}
            for (k in arr.indices) {
                table[j][k] = arr[k]
            }
        }

        readLine()
        val clicks = readLine()?.split(" ")?.map { it.toInt()}

        if (clicks != null) {
            doWork_2(table, clicks, rows, cols)
        }
    }
}
