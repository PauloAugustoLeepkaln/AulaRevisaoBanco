package ProjetoCaixadAgua

import ProjetoCaixadAgua.Entidades.Funcionario
import ProjetoCaixadAgua.Entidades.Servico
import ProjetoCaixadAgua.Enum.Habilidade
import ProjetoCaixadAgua.Enum.Material
import ProjetoCaixadAgua.Enum.Setor
import ProjetoCaixadAgua.Enum.Sexo
import java.math.BigDecimal

fun main() {
    val instalacao : Servico = Servico(

        Funcionario(
            nome ="nome",
            idade = 10,
            altura = 1.80,
            peso = 20.0,
            salario = BigDecimal("2000.00"),
            CPF = "00000000",
            telefone = "000000",
            experiencia = 10,
            setor = Setor.MONTAGEM,
            habilidade = Habilidade.JUNIOR,
            sexo = Sexo.MASCULINO,
        ),
        tipo = "reforma",
        preco = BigDecimal("10000"),
        expediente = 10,
        material = Material.CONCRETO,
        concluido = true
    )
}