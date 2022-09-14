const val N = 3 // num of ships entered
const val M = 5 // total num of rows and cols

fun main() {

    val list = List(N) { readLine()!!.split(' ').map { it.toInt() } }
    val listX = list.map { it[0] }
    val listY = list.map { it[1] }

    var sX = ""
    var sY = ""

    for (i in 1..M) {
        if (i !in listX) {
            sX += "$i "
        }
        if (i !in listY) {
            sY += "$i "
        }
    }
    println(sX.dropLast(1))
    println(sY.dropLast(1))

}