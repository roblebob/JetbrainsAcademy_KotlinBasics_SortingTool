fun main() {
    val x = readLine().toBoolean() // read other values in the same way
    // write your code here
    val y = readLine().toBoolean()
    val z = readLine().toBoolean()
    println(!(x && y) || z)
}