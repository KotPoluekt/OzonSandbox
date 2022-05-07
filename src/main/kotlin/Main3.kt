
fun doWork(input: IntArray): IntArray? {

    var zeroIndex = 0;

    while (zeroIndex < input.size+1) {
        val result = IntArray(input.size + 1)

        result[zeroIndex] = 0

        var cont = true

        for (i in zeroIndex-1 downTo 0) {
            result[i] = -input[i]+result[i+1]
            if (result[i] < 0) {
                zeroIndex++
                cont = false
                break
            }
        }
        if (cont) {
            for (i in zeroIndex + 1..input.size) {
                result[i] = input[i - 1] + result[i - 1]
                if (result[i] < 0) {
                    zeroIndex++
                    cont = false
                    break
                }
            }
        }

        if (cont) {
            return result
        }
    }
    return null
}

fun main(args: Array<String>) {

    readLine()
    val list = readLine()?.split(" ")?.map { it.toInt()}
    //val list = "-2 3 -3 5 -6".split(" ")?.map { it.toInt()}
    val array = list?.toIntArray()

    if (array != null) {
        val result = doWork(array)

        val builder = StringBuilder()
        result?.map { builder.append("$it ") }
        println(builder.toString().trim())
    }
}
