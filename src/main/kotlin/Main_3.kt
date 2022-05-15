fun doWord_3(array: ArrayList<String>) {
    val set = HashSet<String>()

    for (s in array) {
        val ss = s.lowercase()

        if (ss[0] == '-') {
            println("NO")
            continue
        }
        if (ss.length < 2 || ss.length > 24) {
            println("NO")
            continue
        }
        var cont = true
        for (c in ss)
        {
            if (c !in 'a'..'z' && c != '-'&& c != '_' && c !in '0'..'9') {
                cont = false
                break
            }
        }
        if (cont == false) {
            println("NO")
            continue
        }

        if (set.contains(ss)) {
            println("NO")
        } else {
            set.add(ss)
            println("YES")
        }
    }



}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        val tryAmount = Integer.parseInt(readLine())

        val array = ArrayList<String>()
        for (i in 1 .. tryAmount) {
            val ss = readLine()
            if (ss != null) {
                array.add(ss)
            }
        }

        doWord_3(array)
        println()

    }
}
