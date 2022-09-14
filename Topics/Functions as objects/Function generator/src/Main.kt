import java.lang.Exception

// TODO: provide three functions here
fun identity(i: Int): Int {
    return i
}
fun half(i: Int): Int {
    return i / 2
}
fun zero(i: Int): Int {
    return 0
}


fun generate(functionName: String): (Int) -> Int {
    // TODO: provide implementation here
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        else -> ::zero
    }
}