package ProjetoCaixadAgua.Entidades

import java.math.BigDecimal

open class Pessoa (
    val nome: String,
    val idade: Int,
    val CPF: String,
    val telefone: String,
){
    open fun receberConta(conta: Conta, aReceber : BigDecimal){
        conta.saldo = conta.saldo.add(aReceber)
    }
}