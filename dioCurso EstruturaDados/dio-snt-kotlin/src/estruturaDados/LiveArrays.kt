package estruturaDados

fun main() {

        val salario1 = 1000.0
        val salario2 = 2000.0
        val salario3 = 1500.0

        // no dia a dia não é usado
        val maiorSalarioEx1 = if (salario1 > salario2 && salario1 > salario3) {
            salario1
        } else if (salario2 > salario1 && salario2 > salario3) {
            salario2
        } else {
            salario3
        }

        println("Maior salario: $maiorSalarioEx1")
        println("---------------------------------------------")

        // opção com estruturas de dados
        val arrayDeSalarios = DoubleArray(3)
        arrayDeSalarios[0] = 1000.0
        arrayDeSalarios[1] = 2000.0
        arrayDeSalarios[2] = 500.0

        var maiorSalarioEx2 = 0.0 // no kotlin val é imutável var é mutável

        for(salario in arrayDeSalarios) {
            if (salario > maiorSalarioEx2){
                maiorSalarioEx2 = salario
            }
            println("Salario: $salario \n")
        }

        println("Maior salario $maiorSalarioEx2")
        println("---------------------------------------------")


        // outro exemplo mostrando os índices
        for (indice in arrayDeSalarios.indices){
            if (arrayDeSalarios[indice] > maiorSalarioEx2) {
                maiorSalarioEx2 = arrayDeSalarios[indice]
            }
            println("Indice do Salario: ($indice):${arrayDeSalarios[indice]}")
        }
        println("Maior salario $maiorSalarioEx2")
        println("---------------------------------------------")

        // utilizando função sum
        val somaTodosSalarios = arrayDeSalarios.sum()

        println("Soma todos salarios $somaTodosSalarios")
        println("---------------------------------------------")


        // utilizando sorted
        val salariosOrdenados = arrayDeSalarios.sorted()
        println("Salarios ordenados crescente $salariosOrdenados")
        println("---------------------------------------------")

        // utilizando reverse
        val salariosOrdenadosInverso = arrayDeSalarios.sorted().reversed()
        println("Salarios ordenados decrescente $salariosOrdenadosInverso")
        println("---------------------------------------------")


        // outra forma de inicializar o array
        val arrayDeSalarios2 = arrayOf(1000.0, 2000.0, 500.0)
        val salariosOrdenados2 = arrayDeSalarios2.sorted()
        println(salariosOrdenados2)
        println("---------------------------------------------")
    }