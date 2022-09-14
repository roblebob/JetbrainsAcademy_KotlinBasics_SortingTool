fun main() {
    // put your code here
    val letter = readln().toCharArray().first()

    for (c in 'a'..'z') {
        if (c == letter) {
            return
        } else {
            print(c)
        }
    }
}