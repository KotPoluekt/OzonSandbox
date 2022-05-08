fun doWork(s1: CharArray, s2: CharArray): String {

    var input1 = s1.copyOf()
    var input2 = s2

    val size = input1.size
    var result = Array<Char>(size) {'.'}
    val map = HashMap<Char, Int>()

    for (i in 0 until size) {
        if (input1[i] == input2[i]) {
            result[i] = 'G'
            input1[i] = '.'
        } else {
            val v = map[input1[i]]
            if (v == null)
                map[input1[i]] = 1
            else
                map[input1[i]] = v + 1

        }
    }

    for (i in 0 until size) {
        if (result[i] != 'G') {
            val v = map[input2[i]]
            if (v != null && v > 0) {
                result[i] = 'Y'
                map[input2[i]] = v - 1
            }
        }
    }

    val builder = StringBuilder()
    for (s in result) {
        builder.append(s)
    }
    return builder.toString()
}

fun main(args: Array<String>) {

    val str1 = readLine()?.toCharArray() ?: CharArray(0)
    val str2 = readLine()?.toCharArray() ?: CharArray(0)

    println(doWork(str1, str2))
}
