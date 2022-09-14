fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    // put your code here
    return strings.map { if (it == str) "Banana" else it }.toMutableList()
}