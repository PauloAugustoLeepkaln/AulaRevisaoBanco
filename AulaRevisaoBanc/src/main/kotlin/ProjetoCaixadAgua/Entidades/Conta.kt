package ProjetoCaixadAgua.Entidades

import ProjetoCaixadAgua.Enum.TipoConta
import java.math.BigDecimal

open class Conta (

    var receberConta: BigDecimal,
    var saldo: BigDecimal,
    var id: String,
    var tipoConta: TipoConta


    )
{

}