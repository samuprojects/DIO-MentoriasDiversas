package estruturaDados

fun main () {

    val maps = mapOf("mouse" to 3, "teclado" to 1)
    println(maps)

    val maps1 = mapOf(1 to listOf("mouse", "teclado"), 2 to listOf("gabinete", "placa de video"))
    println(maps1)

    println(maps1.keys)

    println(maps1.values)

    // iteração com foreach
    maps1.forEach { key, value ->
        println("$key - $value")
    }

    // contains retorna um booleano para a busca da chave
    val contains = maps1.containsKey(2)
    println(contains)

    val contains2 = maps1.containsKey(4)
    println(contains2)

    // contains também pode usar para o value
    val contains3 = maps1.containsValue(listOf("mouse", "teclado"))
    println(contains3)

}