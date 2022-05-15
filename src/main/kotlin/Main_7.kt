import java.util.TreeSet

var table: Array<Array<Char>>? = null

class Cell() {
    var i = 0;
    var j = 0

    constructor(i: Int, j: Int) : this() {
        this.i = i
        this.j = j
    }

}
class Ship() {
    val cells = HashSet<Cell>()

    fun addCell(cell: Cell) {
        cells.add(cell)
    }
}

fun addCell(ship: Ship, i: Int, j: Int) {
    ship.addCell(Cell(i, j))

    if (table!![i+1][j] == '*') addCell(ship, i+1, j)
    if (table!![i][j+1] == '*') addCell(ship, i, j+1)
    if (table!![i+1][j-1] == '*') addCell(ship, i+1, j-1)
}

fun doWork7(cols: Int, rows: Int) {
    for (j in 0 until cols) {
        for (i in 0 until rows) {
            if (table!![j][i] != '.' && table!![j][i] != '*') {
                println("NO")
                return
            }
        }
    }

    val ships = ArrayList<Ship>()

    for (j in 0 until cols) {
        for (i in 0 until rows) {
            if (table!![j][i] == '*') {

                val ship = Ship()

                addCell(ship, i, j)

                println("NO")
                return
            }
        }
    }


    val res = TreeSet<Int>()



}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        val ss = readLine()
        val rows = Integer.parseInt(ss!!.split(" ")[0])
        val cols = Integer.parseInt(ss!!.split(" ")[1])

        table = Array(rows) { Array(cols) { '0' } }

        for (j in 0 until rows) {
            val s = readLine()

            val arr = s!!.toCharArray()
            for (k in arr.indices) {
                table!![j][k] = arr[k]
            }
        }

        doWork7(cols, rows)
    }
}
