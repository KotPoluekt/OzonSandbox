import java.util.TreeMap

fun build(set: HashSet<String>, map: TreeMap<String, ArrayList<String>>, task: String): ArrayList<String> {
    val res = ArrayList<String>()

    if (!set.contains(task)) {
        set.add(task)

        val arr = map[task]
        if (arr != null && arr.size > 0) {
            for (a in arr) {
                res.addAll(build(set, map, a))
            }
            res.add(task)
        } else {
            res.add(task)
        }
    }

    return res
}
fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine()

        val moduleAmount = Integer.parseInt(readLine())
        val map = TreeMap<String, ArrayList<String>>()

        for (i in 1 .. moduleAmount) {
            val s = readLine()


            if (s != null) {
                val arr = s.split(" ")
                val module = arr[0].substring(0, arr[0].length-1)
                val arrayList = ArrayList<String>()



                for (i in arr.indices) {
                    if (i > 0) {
                        arrayList.add(arr[i])
                    }
                }

                map[module] = arrayList
            }
        }

        val taskAmount = Integer.parseInt(readLine())

        val set = HashSet<String>()

        for (i in 1 .. taskAmount) {
            val task = readLine()

            if (task !=null) {

                val res = build(set, map, task)

                val builder = StringBuilder()
                res.map { builder.append("$it ") }
                val s = builder.toString().trim()

                println("${res.size} $s")
            }
        }
        println()
    }
}
