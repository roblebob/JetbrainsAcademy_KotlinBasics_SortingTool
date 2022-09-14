fun main() {
    // put your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val n = readln().toInt()

    var variation1 = 0
    for (i in a..b) {
        if (i % n == 0) {
            ++variation1
        }
    }

    val variation2 = (a..b).toList().filter { it % n == 0 }.size

    assert(variation1 == variation2)

    println(variation1)
}