fun main(args: Array<String>) {

    val list = IntArray(Integer.parseInt(readLine()))

    for (i in list.indices) {
        val str = readLine()
        val first = Integer.parseInt(str?.substring(0, str.indexOf(" ")))
        val second = Integer.parseInt(str?.substring(str.indexOf(" ") + 1))
        list[i] = first + second
    }

    for (s in list) {
        println(s)
    }
}
