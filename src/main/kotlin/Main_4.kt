import java.util.TreeMap

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        val taskAmount = Integer.parseInt(readLine())

        val map = TreeMap<String, ArrayList<String>>()
        for (i in 1 .. taskAmount) {
            val ss = readLine()

            if (ss != null) {
                val name = ss.split(" ")[0]
                val phone = ss.split(" ")[1]

                val array = map[name]

                if (array == null) {
                    var arr1 = ArrayList<String>()
                    arr1.add(phone)
                    map[name] = arr1
                } else {

                    if (!array.contains(phone)) {
                        if (array.size < 5) {
                            array.add(phone)
                        } else {
                            array.removeAt(0)
                            array.add(phone)
                        }
                    } else {
                        array.remove(phone)
                        array.add(phone)
                    }
                }
            }
        }

        for (key in map.keys) {
            var ss = "$key: "
            val arr = map[key]?.reversed()
            ss += "${arr?.size} "
            arr?.map { ss += "$it " }
            ss = ss.trim()
            println(ss)
        }
        println()
    }
}
