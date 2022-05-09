fun doWork8(table: Array<Array<Char>>): String {
    // кол-во крестиков
    var crosses = 0
    // кол-во ноликов
    var zeroes = 0

    for (i in 0..2) {
        for (j in 0..2) {
            if (table[i][j] == 'X') crosses++
            if (table[i][j] == '0') zeroes++
        }
    }

    // крестиков мб на 1 меньше или равно
    if (!(crosses == zeroes || crosses-1 == zeroes)) return "NO"

    var crossesIsWin =  (table[0][0] == 'X' && table[0][1] == 'X' && table[0][2] == 'X') ||
                        (table[1][0] == 'X' && table[1][1] == 'X' && table[1][2] == 'X') ||
                        (table[2][0] == 'X' && table[2][1] == 'X' && table[2][2] == 'X') ||
                        (table[0][0] == 'X' && table[1][0] == 'X' && table[2][0] == 'X') ||
                        (table[0][1] == 'X' && table[1][1] == 'X' && table[2][1] == 'X') ||
                        (table[0][2] == 'X' && table[1][2] == 'X' && table[2][2] == 'X') ||
                        (table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X') ||
                        (table[2][0] == 'X' && table[1][1] == 'X' && table[0][2] == 'X')

    var zeroesIsWin =  (table[0][0] == '0' && table[0][1] == '0' && table[0][2] == '0') ||
            (table[1][0] == '0' && table[1][1] == '0' && table[1][2] == '0') ||
            (table[2][0] == '0' && table[2][1] == '0' && table[2][2] == '0') ||
            (table[0][0] == '0' && table[1][0] == '0' && table[2][0] == '0') ||
            (table[0][1] == '0' && table[1][1] == '0' && table[2][1] == '0') ||
            (table[0][2] == '0' && table[1][2] == '0' && table[2][2] == '0') ||
            (table[0][0] == '0' && table[1][1] == '0' && table[2][2] == '0') ||
            (table[2][0] == '0' && table[1][1] == '0' && table[0][2] == '0')

    if (crossesIsWin && crosses != zeroes+1) return "NO"
    if (crossesIsWin && zeroesIsWin) return "NO"
    if (zeroesIsWin && crosses != zeroes) return "NO"

    return "YES"
}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine()
        val table: Array<Array<Char>> = Array(3) { Array(3) { '0' } }

        for (j in 0 until 3) {
            val s = readLine()

            val arr = s!!.toCharArray()
            for (k in arr.indices) {
                table[j][k] = arr[k]
            }
        }

        println(doWork8(table))
    }
}
