fun doWork7(rows: Int, cols: Int, table: Array<Array<Char>>) {
    // сперва все блоки падают
    for (j in 0 until cols) {
        var count = 0
        for (i in 0 until rows) {
            val c = table[i][j]
            if (c == '*') count++
        }
        for (i in rows-1 downTo 0 ) {
            val c = if (rows - i <= count) '*' else '.'
            table[i][j] = c
        }
    }

    // заполняем водой
    for (j in 1 until cols-1) {
        for (i in rows-1 downTo 0 ) {
            if (table[i][j] == '.') {

                //  если слева есть вода
                if (table[i][j-1] == '~') {
                    table[i][j] = '~'
                } else {
                    //  если ГДЕ_ТО слева и справа есть блок
                    var leftBlock = false
                    for (jj in j - 1 downTo 0) {
                        if (table[i][jj] == '*') {
                            leftBlock = true
                            break
                        }
                    }
                    var rightBlock = false
                    if (leftBlock) {
                        for (jj in j + 1 until cols) {
                            if (table[i][jj] == '*') {
                                rightBlock = true
                                break
                            }
                        }
                    }
                    if (leftBlock && rightBlock) {
                        table[i][j] = '~'
                    }
                }
            }
        }
    }

    // рисуем результат
    for (i in 0 until rows) {
        val builder = StringBuilder()
        table[i].map { builder.append("$it") }
        println(builder.toString().trim())
    }
    println()
}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        val ss = readLine()
        val rows = Integer.parseInt(ss!!.split(" ")[0])
        val cols = Integer.parseInt(ss!!.split(" ")[1])

        val table: Array<Array<Char>> = Array(rows) { Array(cols) { '0' } }

        for (j in 0 until rows) {
            val s = readLine()

            val arr = s!!.toCharArray()
            for (k in arr.indices) {
                table[j][k] = arr[k]
            }
        }

        doWork7(rows, cols, table)
    }
}
