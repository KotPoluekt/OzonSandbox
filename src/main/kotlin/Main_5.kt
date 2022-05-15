import java.util.TreeSet

fun doWork_5(array: IntArray, number: Int, type: Int) {
    if (type == 1) {

    } else if (type == 2) {

    } else {


    }
}

fun main(args: Array<String>) {

    val setAmount = Integer.parseInt(readLine())

    for (i in 1 .. setAmount) {
        readLine()

        val ss = readLine()
        val cupe = Integer.parseInt(ss!!.split(" ")[0])
        val requests = Integer.parseInt(ss!!.split(" ")[1])

        val array = IntArray(cupe*2){0}
        val emptyCupe = TreeSet<Int>()
        for (i in 0 until cupe) {
            emptyCupe.add(i)
        }

        for (j in 1 .. requests) {
            val s = readLine()

            if (s != null) {
                if (s[0] == '1') {
                    // request 1
                    val number = Integer.parseInt(s!!.split(" ")[1]) - 1

                    if (number < array.size && array[number] == 0) {
                        array[number] = 1
                        if (number % 2 == 0) {
                            emptyCupe.remove(number/2 )
                        } else {
                            emptyCupe.remove((number - 1)/2)
                        }

                        println("SUCCESS")
                    } else {
                        println("FAIL")
                    }

                } else if (s[0] == '2') {
                    // request 2
                    val number = Integer.parseInt(s!!.split(" ")[1]) - 1
                    if (number < array.size && array[number] == 1) {
                        array[number] = 0
                        println("SUCCESS")

                        if (number % 2 == 0) {
                            if (array[number + 1] == 0) {
                                emptyCupe.add(number / 2)
                            }
                        } else {
                            if (array[number - 1] == 0) {
                                emptyCupe.add((number - 1) / 2)
                            }
                        }

                    } else {
                        println("FAIL")
                    }
                } else if (s == "3") {
                    // request 3
//                    var found = false
//                    for (i in array.indices step 2) {
//                        if (i < array.size) {
//                            if (array[i] == 0 && array[i + 1] == 0) {
//                                array[i] = 1
//                                array[i + 1] = 1
//                                println("SUCCESS ${i + 1}-${i + 2}")
//                                found = true
//                                break
//                            }
//                        }
//                    }
//                    if (found == false)                   println("FAIL")

                    if (emptyCupe.size > 0) {
                        val s = emptyCupe.pollFirst()
                        array[s*2] = 1
                        array[s*2+1] = 1

                        println("SUCCESS ${s*2 + 1}-${s*2 + 1 + 1}")
                    } else {
                        println("FAIL")
                    }
                }
            }
        }

        println()
    }
}
