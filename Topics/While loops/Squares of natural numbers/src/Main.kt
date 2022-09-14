fun main() {
    // put your code here
    val n = readLine()!!.toInt()
    var i = 1

    while (square(i) <= n) {
        println(square(i))
        i++
    }
}

fun square(num: Int): Int {
    return num * num
}