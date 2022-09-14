package sorting

import java.io.File
import kotlin.Exception
import java.util.*


fun main(args: Array<String>) {

    val setup = try { processArgs(args) } catch (e: Exception) {
        println(e.message)
        return
    }
    /* to manually enforce settings upon setup */
//    setup["-sortingType"] = "byCount"
//    setup["-dataType"] = "line"
//    setup["-inputFile"] = "data.txt"
//    setup["-outputFile"] = "output.txt"


    val outputMsg = getOutputMsg(setup)

    if (setup.contains("-outputFile")) {
        File(setup["-outputFile"]!!).writeText(outputMsg)
    }
    println(outputMsg)
}




fun getOutputMsg(setup: MutableMap<String, String>) : String {





    when (setup["-sortingType"]) {
        "natural" -> {
            when (setup["-dataType"]) {
                "long" -> {
                    val list = mutableListOf<Int>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readText().
                            split("\\s".toRegex()).
                            toMutableList().
                            filter { it != "" }.
                            map { it.toInt() }
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.nextInt()
                        }
                        scanner.close()
                    }

                    val separator = " "
                    return "Total numbers: ${list.size}.\n" +
                            "Sorted data:$separator${list.sorted().joinToString(separator)}"
                }
                "word" -> {
                    val list = mutableListOf<String>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readText().
                            split("\\s".toRegex()).
                            toMutableList().
                            filter { it != "" }
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.next()
                        }
                        scanner.close()
                    }

                    val separator = " "
                    return "Total words: ${list.size}.\n" +
                            "Sorted data:$separator${list.sorted().joinToString(separator)}"
                }
                "line" -> {
                    val list = mutableListOf<String>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readLines()
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.nextLine()
                        }
                        scanner.close()
                    }

                    val separator = "\n"
                    return "Total lines: ${list.size}.\n" +
                            "Sorted data:$separator${list.sorted().joinToString(separator)}"
                }
                else -> return "Error, invalid -dataType"
            }
        }
        "byCount" -> {
            when (setup["-dataType"]) {
                "long" -> {
                    val list = mutableListOf<Int>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readText().
                            split("\\s".toRegex()).
                            toMutableList().
                            filter { it != "" }.
                            map { it.toInt() }
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.nextInt()
                        }
                        scanner.close()
                    }

                    return "Total numbers: ${list.size}." + sortingByCount(list)
                }
                "word" -> {
                    val list = mutableListOf<String>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readText().
                            split("\\s".toRegex()).
                            toMutableList().
                            filter { it != "" }
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.next()
                        }
                        scanner.close()
                    }

                    return "Total words: ${list.size}." + sortingByCount(list)
                }
                "line" -> {
                    val list = mutableListOf<String>()

                    if (setup.contains("-inputFile")) {
                        list.addAll(
                            File(setup["-inputFile"]!!).
                            readLines()
                        )
                    } else {
                        val scanner = Scanner(System.`in`)
                        while (scanner.hasNext()) {
                            list += scanner.nextLine()
                        }
                        scanner.close()
                    }

                    return "Total lines: ${list.size}." + sortingByCount(list)
                }
                else -> return "Error, invalid -dataType"
            }
        }
        else -> return "Error, invalid -sortingType"
    }
}









fun <T: Comparable<T>> sortingByCount(list: List<T>): String {

    var outputString = ""

    val mMap = mutableMapOf<T, Int>()

    for (key in list.sorted().toSet()) {
        mMap[key] = Collections.frequency(list, key)
    }
    val mMapSorted = mMap.toList().sortedBy { (_, value) -> value }.toMap()

    for ((key, value) in mMapSorted) {
        outputString += "\n$key: $value time(s), ${percentage(value, list.size)}%"
    }

    return outputString
}







fun processArgs(args: Array<String>): MutableMap<String, String>{

    val mArgs = args.toMutableList()  // preparing the input
    val mSetup = mutableMapOf<String, String>()  // preparing what will be known as the setup preferences

    while (mArgs.isNotEmpty()) {

        if (mArgs[0] == "-sortingType" && (mArgs.size == 1 || mArgs[1] !in setOf("natural", "byCount")) ) {
            throw Exception("No sorting type defined!")
        } else if (mArgs[0] == "-dataType" && (mArgs.size == 1 || mArgs[1] !in setOf("long", "word", "line")) ) {
            throw Exception("No data type defined!")
        }
        else if (  (mArgs[0] == "-sortingType" && mArgs.size > 1 && mArgs[1] in setOf("natural", "byCount")  ) ||
            ( mArgs[0] == "-dataType" && mArgs.size > 1 &&  mArgs[1] in setOf("long", "word", "line")   ) ||
            ( mArgs[0] in setOf( "-inputFile", "-outputFile")  &&  mArgs.size > 1 && mArgs[1].first() != '-' )
        ){

            mSetup[mArgs[0]] = mArgs[1]

            mArgs.removeFirst()
            mArgs.removeFirst()
        }
        else {
            println("\"${args[0]}\" is not a valid parameter. It will be skipped.")
            mArgs.removeFirst()
        }

    }

    // defining defaults
    if (!mSetup.contains("-dataType")) {
        mSetup["-dataType"] = "word"
    }

    if (!mSetup.contains("-sortingType")) {
        mSetup["-sortingType"] = "natural"
    }


    return mSetup
}



fun percentage(n: Int, N: Int): Int {
    return (100.0 * n.toDouble() / N.toDouble()).toInt()
}