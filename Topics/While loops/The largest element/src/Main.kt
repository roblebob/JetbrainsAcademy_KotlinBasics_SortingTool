fun main() {

    var max = Int.MIN_VALUE
    var input = readln().toInt()

    while (input != 0) {
        if (input > max) {
            max = input
        }
        input = readln().toInt()
    }
    if (max > Int.MIN_VALUE) {
        println(max)
    }
}