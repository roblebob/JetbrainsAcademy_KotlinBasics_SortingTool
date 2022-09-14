const val g = 9.8 // gravity constant [m/s²]

fun main() {
    // write your code here
    val rho = readLine()!!.toDouble() // density of a liquid
    val h = readLine()!!.toDouble() // height of a column

    val p = rho * g * h
    println(p)
}