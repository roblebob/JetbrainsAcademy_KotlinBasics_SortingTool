fun solution(numbers: List<Int>) {
    // put your code here
    var isFirstTime = true
    for (el in numbers) {
        if (el % 2 == 0) {
            if (isFirstTime) {
                print(el)
                isFirstTime = false
            } else {
                print(" $el")
            }
        }
    }
}