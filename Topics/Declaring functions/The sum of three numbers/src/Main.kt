// write your function here

fun main() {    
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val sum = {x: Int, y: Int, z: Int -> x + y + z}

    println(sum(a, b, c))
}

