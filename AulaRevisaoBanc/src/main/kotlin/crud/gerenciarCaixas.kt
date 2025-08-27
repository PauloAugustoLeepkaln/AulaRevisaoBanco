package crud

import ProjetoCaixadAgua.Entidades.CaixaDAgua
import ProjetoCaixadAgua.Enum.MaterialCaixa
import ProjetoCaixadAgua.Enum.Corcaixa
import ProjetoCaixadAgua.Enum.Material

fun cadastrarCaixa(){
    /*
    val material : MaterialCaixa,
    val capacidade : Int,
    val cor : Corcaixa,
    val peso : Double,
    val preco : BigDecimal?,
    val altura : Double,
    val largura: Double,
    val profundidade : Double,
    PLASTICO, CONCRETO, METAL, ARGAMASSA
        PRETO, AZUL, BRANCO
     */
    println("Escolha o material do qual a caixa é composta:")
    println("1 - Plástico")
    println("2 - Concreto")
    println("3 - Metal")
    println("4 - Argamassa")

    val opcao = readln().toInt()
    var material : MaterialCaixa
    when(opcao){
        1-> material = MaterialCaixa.PLASTICO
        2-> material = MaterialCaixa.CONCRETO
        3-> material = MaterialCaixa.METAL
        4-> material = MaterialCaixa.ARGAMASSA
        else -> material = MaterialCaixa.PLASTICO
    }

    println("Capacidade da caixa em litros:")
    val litros = readln().toInt()

    var cor : Corcaixa
    when(opcao){
        1-> cor = Corcaixa.AZUL
        2-> cor = Corcaixa.PRETO
        3-> cor = Corcaixa.BRANCO
        else -> cor = Corcaixa.AZUL
    }

    println("Fale o peso:")
    val peso = readln().toDouble()

    println("Preço da caixa:")
    val preco = readln().toBigDecimal()

    println("Altura da caixa:")
    val altura = readln().toDouble()

    println("Largura da caixa:")
    val largura = readln().toDouble()

    println("Profundidade da caixa:")
    val profundidade = readln().toDouble()

    CaixaDAgua(
        material = material,
        capacidade = litros,
        cor = cor,
        preco = preco,
        altura = altura,
        largura = largura,
        peso = peso,
        profundidade = profundidade
    )

}

fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}