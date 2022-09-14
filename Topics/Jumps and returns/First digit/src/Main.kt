fun main() {
    val input = readln()
    for (c in input) {
        if (c in '1'..'9') {
            println(c)
            break
        }
    }
}