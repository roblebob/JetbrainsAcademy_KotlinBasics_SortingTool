fun main() {
    val numbers = MutableList<Int> (100) { 0 }
    for (i in 0 until numbers.size) {
        if (i in mutableListOf(0, 9, 99)) {
            numbers[i] = i + 1
        }
    }
    // do not touch the lines below 
    println(numbers.joinToString())
}