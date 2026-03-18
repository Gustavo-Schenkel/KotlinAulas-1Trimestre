import kotlin.collections.component1

val estoque: MutableMap<String, Double> = mutableMapOf(
    "Arroz" to 12.25,
    "Feijão" to 4.85,
    "Macarrão" to 7.86,
    "Batata" to 0.86,
    "Maizena" to 5.75,
    "Farinha" to 9.86
)
var rodando: Boolean = true

fun main() {

    println("BEM VINDO AO ESTQ.MERCADINHO V2!")
    while (rodando) {

        println("-------------------------------")
        println("Selecione uma opção: ")
        println("1 - Visualizar estoque")
        println("2 - Adicionar mercadoria")
        println("3 - Remover mercadoria")
        println("4 - Alterar preço")
        println("5 - Encerrar programa")

        val opcao = readln().toInt()  //Le o digito do usuário

        when (opcao) {
            1 -> mercadoria()
            2 -> adcMercadoria()
            3 -> rmvMercadoria()
            4 -> altPreco()
            5 -> finalizar()
            else -> println("Opção inválida!")
        }
    }
}

fun mercadoria() {
    println("Os produtos em estoque são: ")
    //estoque, para cada NOME e VALOR, escreva na tela o NOME e o VALOR.
    estoque.forEach { (nome, valor) ->
        println("$nome: $valor")
    }
}

fun adcMercadoria() {

    println("Digite o nome da mercadoria: ")
    val resposta = readln()

    println("Digite o valor da mercadoria: ")
    val valor = readln().toDouble()

    estoque[resposta] = valor
    println("Produto $resposta R$ $valor foi ADICIONADO AO ESTOQUE!")
}

fun rmvMercadoria() {

    println("Selecione a mercadoria a ser removida: ")
    estoque.forEach { (nome) ->
        println(nome)
    }

    //após a tabela ficar a mostra, a variavel vai ler o nome que o usuario digitar
    val opcao = readln()

    //se o estoque conter a chave OPCAO, ou seja, a exata palavra que o usuario digitar,
    //o sistema remove a chave escolhida.
    if (estoque.containsKey(opcao)) {
        estoque.remove(key = opcao)
        println("\nEstoque Atualizado!")
    }
}

fun altPreco() {

    println("Qual produto gostaria de alterar o valor? ")
    estoque.forEach { (nome, valor) ->
        println("$nome, $valor")
    }
    //pegar a RESPOSTA do usuário e procurar a string no MAP
    val resposta = readln()
    println("Você selecionou $resposta!, qual o valor novo?")

    // Variavel para alterar o que o usuario digitar para double
    val valorNovo = readln().toDouble()

    if (estoque.containsKey(resposta)) {
        estoque[resposta] = valorNovo
    }

    println("\nEstoque Atualizado! O valor novo de $resposta é $valorNovo")

}

fun finalizar() {
    println("Finalizando o programa... Obrigado!")
    rodando = false
}