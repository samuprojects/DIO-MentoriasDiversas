package estruturaDados

data class Produto(val name: String, val valor: Double)

class CarrinhoDeCompras() {

    private val listaDeProdutos: MutableList<Produto> = mutableListOf()

    fun quantidadeDeProdutos(): Int {
        return listaDeProdutos.size
    }

    fun listaProdutos() {
        println("Quantidade ${quantidadeDeProdutos()} - Lista de produtos: $listaDeProdutos")
    }

    fun listarProdutosPorOrdem(criterio: String) {
        when (criterio) {
            "nome" -> {
                val produtosOrdenadosPorNome = listaDeProdutos.sortedBy { it.name }
                println("Ordem dos produtos por nome: $produtosOrdenadosPorNome")
            }
            "valor" -> {
                val produtosOrdenadosPorValor = listaDeProdutos.sortedBy { it.valor }
                println("Ordem dos produtos por valor: $produtosOrdenadosPorValor")
            }
            "nome_desc" -> {
                val produtosOrdenadosPorNomeDesc = listaDeProdutos.sortedByDescending { it.name }
                println("Ordem dos produtos por nome (decrescente): $produtosOrdenadosPorNomeDesc")
            }
            "valor_desc" -> {
                val produtosOrdenadosPorValorDesc = listaDeProdutos.sortedByDescending { it.valor }
                println("Ordem dos produtos por valor (decrescente): $produtosOrdenadosPorValorDesc")
            }
            "nome_e_valor" -> {
                val produtosOrdenadosPorNomeEValor = listaDeProdutos.sortedWith(compareBy<Produto> { it.name }.thenBy { it.valor })
                println("Ordem dos produtos por nome e valor: $produtosOrdenadosPorNomeEValor")
            }
            else -> println("Critério desconhecido. Use 'nome', 'valor', 'nome_desc', 'valor_desc' ou 'nome_e_valor'.")
        }
    }

    fun adicionarProduto(produto: Produto) {
        listaDeProdutos.add(produto)
    }

    fun removerProduto(posicao: Int) {
        listaDeProdutos.removeAt(posicao)
    }

    fun removerProduto(produto: Produto) {
        listaDeProdutos.remove(produto)
    }

    fun buscarProdutoPorNome(nome: String) {
        val produtos = listaDeProdutos.filter { produto ->
            (produto.name.contains(nome))
        }
        println("produtos encontrados: $produtos")
    }

    fun produtoMaisCaro() : Produto? {
        return listaDeProdutos.maxByOrNull { produto ->
            produto.valor
        }
    }

    fun produtoMaisBarato() : Produto? {
        return listaDeProdutos.minByOrNull {
            it.valor
        }
    }

    fun somaDosProdutos() : Double {
        // return listaDeProdutos.sumByDouble { it.valor } esse código do professor IDE consta como deprecated sugerindo:
        return listaDeProdutos.sumOf { it.valor }
    }

    fun esvaziar(){
        listaDeProdutos.removeAll(listaDeProdutos)
    }
}

    fun main() {
        val carrinhoDeCompras = CarrinhoDeCompras()
        carrinhoDeCompras.listaProdutos()

        val produto1 = Produto("Mouse", 35.0)
        val produto2 = Produto("Teclado", 50.0)
        val produto3 = Produto("Pilha top de linha", 50.0)
        val produto4 = Produto("Microfone profissional", 500.0)
        val produto5 = Produto("Fone de ouvido profissional", 200.0)
        carrinhoDeCompras.adicionarProduto(produto1)
        carrinhoDeCompras.adicionarProduto(produto2)
        carrinhoDeCompras.adicionarProduto(produto3)
        carrinhoDeCompras.adicionarProduto(produto4)
        carrinhoDeCompras.adicionarProduto(produto5)
        carrinhoDeCompras.listaProdutos()
        carrinhoDeCompras.removerProduto(0)
        carrinhoDeCompras.listaProdutos()
        carrinhoDeCompras.adicionarProduto(produto1)
        carrinhoDeCompras.listaProdutos()
        carrinhoDeCompras.removerProduto(produto1)
        carrinhoDeCompras.listaProdutos()

        carrinhoDeCompras.adicionarProduto(produto1)
        carrinhoDeCompras.buscarProdutoPorNome("Mouse")

        println("Produto mais caro: ${carrinhoDeCompras.produtoMaisCaro()}")
        println("Produto mais barato: ${carrinhoDeCompras.produtoMaisBarato()}")
        println("Total do carrinho: ${carrinhoDeCompras.somaDosProdutos()}")

        carrinhoDeCompras.listarProdutosPorOrdem("nome")
        carrinhoDeCompras.listarProdutosPorOrdem("valor")
        carrinhoDeCompras.listarProdutosPorOrdem("nome_desc")
        carrinhoDeCompras.listarProdutosPorOrdem("valor_desc")
        carrinhoDeCompras.listarProdutosPorOrdem("nome_e_valor")

        carrinhoDeCompras.esvaziar()
        carrinhoDeCompras.listaProdutos()


    }

