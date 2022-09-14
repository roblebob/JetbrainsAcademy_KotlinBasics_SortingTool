fun main() {
    // put your code here
    val num = readLine()!!.toInt()

    println(
        when (num) {
            in setOf<Int>(0, 1, 2, 3, 5, 8, 13, 21, 34, 55) -> "F"
            in setOf<Int>(0, 1, 3, 6, 10, 15, 21, 28, 36, 45) -> "T"
            in setOf<Int>(1, 10, 100, 1000, 10000, 100000) -> "P"
            else -> "N"
        }
    )
}