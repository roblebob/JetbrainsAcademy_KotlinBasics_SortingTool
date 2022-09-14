fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Invalid number of program arguments")
        return
    }
    for (i in args.indices) {
        println("Argument ${i + 1}: ${args[i]}. It has ${args[i].length} characters")
    }
}