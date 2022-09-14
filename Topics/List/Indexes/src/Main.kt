fun solution(products: List<String>, product: String) {
    // put your code here
    var isFirstTime = true
    for (i in products.indices) {
        if (products[i] == product) {
            if (isFirstTime) {
                print(i)
                isFirstTime = false
            } else {
                print(" $i")
            }
        }
    }
}