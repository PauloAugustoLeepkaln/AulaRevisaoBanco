package ProjetoCaixadAgua.Entidades

import ProjetoCaixadAgua.Enum.Habilidade
import ProjetoCaixadAgua.Enum.Setor
import ProjetoCaixadAgua.Enum.Sexo
import java.math.BigDecimal

class Funcionario (
    nome: String,
    idade: Int,
    val altura: Double,
    val peso: Double,
    val salario: BigDecimal,
    CPF: String,
    telefone: String,
    var experiencia: Int, //anos
    val setor: Setor,
    val habilidade: Habilidade,
    val sexo: Sexo
): Pessoa(
    nome = nome,
    idade = idade,
    CPF = CPF,
    telefone = telefone,
)

{
    //Comportamentos do profissional
    fun instalarCaixaDAgua(clt : Funcionario){
        if(clt. setor.equals(Setor.MONTAGEM)) {
            println("Profissional habilitado")
        } else {
            println ("Profissional desqualificado")

        }
    }
    override fun receberConta(conta : Conta, aPagar : BigDecimal){
        conta.saldo = conta.saldo.subtract(aPagar)
    }
}


