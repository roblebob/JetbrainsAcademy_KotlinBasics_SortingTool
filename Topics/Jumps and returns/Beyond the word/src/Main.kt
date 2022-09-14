fun main() {
    val word = readln()
    for (c in 'a'..'z') {
        if (c in word) continue
        print(c)
    }
}