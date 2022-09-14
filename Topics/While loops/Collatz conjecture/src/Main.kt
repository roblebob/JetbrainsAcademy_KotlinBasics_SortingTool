fun main() {
    // put your code here
    val n = readln().toInt()
    val list = mutableListOf(n)
    while (list.last() != 1) {
        if (list.last() % 2 == 0) {
            list.add(list.last() / 2)
        } else {
            list.add(list.last() * 3 + 1)
        }
    }
    println(list.joinToString(" "))
}