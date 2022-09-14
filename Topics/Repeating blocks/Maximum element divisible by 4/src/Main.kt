fun main() {
    // put your code here
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    println(list.filter { it % 4 == 0 }.maxOrNull())
}