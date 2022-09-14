fun main() {
    var input = readln()
    for (i in input.indices) {
        if (input[i] != ' ' && input.count { it == input[i] } != 1) {
            input = input.replace(input[i], ' ')
        }
    }
    input = input.replace(" ", "")
    println(input.length)
}