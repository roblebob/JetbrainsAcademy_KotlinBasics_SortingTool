const val IDX1 = 0
const val IDX10 = 9
const val IDX100 = 99
const val N = 100

fun main() {
    val numbers = IntArray(N)
    numbers[IDX1] = IDX1 + 1
    numbers[IDX10] = IDX10 + 1
    numbers[IDX100] = IDX100 + 1

    // do not touch the lines below
    println(numbers.joinToString())
}