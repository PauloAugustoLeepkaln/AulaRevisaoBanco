package ProjetoCaixadAgua.Entidades

import ProjetoCaixadAgua.Enum.Material
import java.math.BigDecimal

class Servico(
    var funcionario: Funcionario,
    var tipo: String,
    var preco: BigDecimal,
    var expediente: Int,
    val material: Material,
    var concluido: Boolean
    ) {
}