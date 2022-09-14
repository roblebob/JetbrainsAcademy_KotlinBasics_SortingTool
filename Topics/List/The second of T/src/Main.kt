const val S = 'T'

fun solution(names: List<String>): Int {
    // put your code here
    for (i in 1 until names.size step 2) {
        if (names[i][0] == S) {
            return i
        }
    }
    return -1
}