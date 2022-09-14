fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
    // Do not touch lines above
    // Write only exchange actions here.
    if (numbers.size > 1) {
        numbers[0] += numbers.last()
        numbers[numbers.lastIndex] = numbers.first() - numbers.last()
        numbers[0] = numbers.first() - numbers.last()
    }
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
}