fun main() {
    val (hour, min, sec) = readln().split(' ')
    val (month, day, year) = readln().split(' ')
    println("$hour:$min:$sec $month/$day/$year")
}