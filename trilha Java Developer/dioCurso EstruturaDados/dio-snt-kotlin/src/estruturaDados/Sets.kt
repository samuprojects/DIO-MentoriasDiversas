package estruturaDados

fun main () {


    val nomes = setOf<String>("Carol", "Carol", "Luis")
    println(nomes)
    println(nomes.size)

    nomes.forEach {
        println(it)
    }

    val retorno = nomes.filter { it == "Carol" }
    println(retorno)

    val retorno1 = nomes.any { it == "Carol" } // retorna um booleano
    println(retorno1)

    val retorno2 = nomes.all { it == "Carol" } // retorna um booleano para indicar se todos são "Carol"
    println(retorno2)

    val clientesPF = setOf<String>("Carol", "Nath", "Zé")
    val clientesPJ = setOf<String>("Carol", "Samu", "Luis")

    val clientes = clientesPF.union(clientesPJ) // retorna um novo set com nomes únicos
    println(clientes)

    val clientes1 = clientesPF.subtract(clientesPJ) // subtrai os clientes da primeira lista que estão na segunda
    println(clientes1)

    val clientes2 = clientesPJ.subtract(clientesPF) // subtrai os clientes da primeira lista que estão na segunda
    println(clientes2)

    val clientes3 = clientesPF.intersect(clientesPJ) // retorna o que tem em comum entre os dois conjuntos
    println(clientes3)

}


