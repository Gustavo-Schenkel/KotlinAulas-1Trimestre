fun main() {

    val numeros = mutableListOf<String>()

    println("=== CALCULADORA ===")
    println("Digite um número:")

    //le o numero que o user digitar
    val entrada = readln()

    //adiciona o numero digitado (que é lido pela val = entrada) na lista do val numeros
    numeros.add(entrada)



    while (true) {

        println("Digite um operador (+, -, *, /) ou '=' para calcular:")
        val operador = readln()

        if (operador == "=") {
            val resultado = calcular(numeros)
            println("Resultado: $resultado")
            break
        }

        // adiciona na lista numeros o valor digitado do operador, formando uma linha (ex: 1, +, 2,...)
        numeros.add(operador)

        println("Digite o próximo número:")
        val numero = readln()

        numeros.add(numero)
    }
}
fun calcular(numeros: MutableList<String>): Double {

    val lista = numeros.toMutableList()

    resolverMultDiv(lista)
    return resolverSomaSub(lista)
}
fun resolverMultDiv(numeros: MutableList<String>) {

    var i = 0

    while (i < numeros.size) {
        if (numeros[i] == "*" || numeros[i] == "/") {

            val a = numeros[i - 1].toDouble()
            val b = numeros[i + 1].toDouble()

            val resultado = if (numeros[i] == "*") a * b else a / b

            numeros.removeAt(i + 1)
            numeros.removeAt(i)
            numeros[i - 1] = resultado.toString()

            i--
        } else {
            i++
        }
    }
}
fun resolverSomaSub(numeros: MutableList<String>): Double {

    var resultado = numeros[0].toDouble()
    var i = 1

    while (i < numeros.size) {

        val operador = numeros[i]
        val valor = numeros[i + 1].toDouble()

        resultado = if (operador == "+") {
            resultado + valor
        } else {
            resultado - valor
        }

        i += 2
    }

    return resultado
}
