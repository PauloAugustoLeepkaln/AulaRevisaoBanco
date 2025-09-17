package crud

import ProjetoCaixadAgua.Entidades.CaixaDAgua
import ProjetoCaixadAgua.Enum.MaterialCaixa
import ProjetoCaixadAgua.Enum.Corcaixa
import ProjetoCaixadAgua.Enum.Material
import java.sql.ResultSet

val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5432/projetocaixa",
        usuario = "postgres",
        senha = "postgres"
    )

fun criarTabelaCaixa(){

    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY," +
            " material varchar(255)," + //Enumeradores serão STRINGS no banco
            " capacidade float," +
            " cor varchar(255)," +
            " peso float," +
            " preco varchar(255)," +
            " altura float," +
            " largura float," +
            " profundidade float" +
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)//Se retornar false ou 1, deu certo!

    banco.close()//encerra a conexão
}



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

    var c = CaixaDAgua(
        material = material,
        capacidade = litros,
        cor = cor,
        preco = preco,
        altura = altura,
        largura = largura,
        peso = peso,
        profundidade = profundidade
    )
    val banco = conectar.conectarComBanco()!!.prepareStatement(
        "INSERT INTO CaixaDAgua" +
                " (material, capacidade, cor, preco, altura, largura, peso, profundidade)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
    )
        banco.setString(1, c.material.name)
        banco.setDouble(2, c.capacidade!!.toDouble())
        banco.setString(3, c.cor.name)
        banco.setString(4, c.preco.toString())
        banco.setDouble(5, c.altura)
        banco.setDouble(6, c.largura)
        banco.setDouble(7, c.peso)
        banco.setDouble(8, c.profundidade)

        banco.executeUpdate()

        banco.close()
}

fun editarCaixa(c: CaixaDAgua){
    println("digite o ID")
    var id = readln.toInt()
    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val statement = conecao!!.prepareStatement(jpql)


    if id
    statement.setString(1, c.material.name)
    statement.setDouble(2, c.capacidade!!)
    statement.setDouble(3, c.altura)
    statement.setDouble(4, c.largura)
    statement.setDouble(5, c.profundidade)
    statement.setString(6, c.)
    statement.setLong(7, c.)
    statement.executeUpdate()

    while (retorno.next()){
        banco.setString(1, c.material.name)
        banco.setDouble(2, c.capacidade!!.toDouble())
        banco.setString(3, c.cor.name)
        banco.setString(4, c.preco.toString())
        banco.setDouble(5, c.altura)
        banco.setDouble(6, c.largura)
        banco.setDouble(7, c.peso)
        banco.setDouble(8, c.profundidade)
    } else {
        val sql = "UPDATE FROM CaixaDAgua Set" +
                " material = ?" +
                " capacidade = ?" +
                " cor = ?" +
                " preco = ?" +
                " altura = ?" +
                " largura = ?" +
                " peso = ?" +
                " profundidade = ?"

        val editar = banco.prepareStatement(sql)
        editar.setInt(8,id)
        banco.setString(1, c.material.name)
        banco.setDouble(2, c.capacidade!!.toDouble())
        banco.setString(3, c.cor.name)
        banco.setString(4, c.preco.toString())
        banco.setDouble(5, c.altura)
        banco.setDouble(6, c.largura)
        banco.setDouble(7, c.peso)
        banco.setDouble(8, c.profundidade)
        editar.close()
    }


    println("Faça suas alterações: ")
    cadastrarCaixa(id)
    banco.close()

}

fun listarCaixas(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    //Após consultar o banco usando um SQL junto da função executeQuery
    //a consulta, se acertiva, retorna um array de respostas
    val  resultados : ResultSet = banco!!.createStatement().executeQuery(sql)

    while (resultados.next()){
        //Para cada consulta, use o nome que está no banco!
        println("----------------------------------------------")
        println("id: ${resultados.getString("id")}")
        println("material: ${resultados.getString("material")}")
        println("capacidade: ${resultados.getString("capacidade")}")
        println("cor: ${resultados.getString("cor")}")
        println("peso: ${resultados.getString("peso")}")
        println("preco: ${resultados.getString("preco")}")
        println("altura: ${resultados.getString("altura")}")
        println("largura: ${resultados.getString("largura")}")
        println("profundidade: ${resultados.getString("profundidade")}")
    }
    banco.close()

}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir")
    val id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1, id)
    val retorno = resultados.executeQuery()
    while(retorno.next()) {
        println("----------------------------------------------")
        println("id: ${retorno.getString("id")}")
        println("material: ${retorno.getString("material")}")
        println("capacidade: ${retorno.getString("capacidade")}")
        println("cor: ${retorno.getString("cor")}")
        println("peso: ${retorno.getString("peso")}")
        println("preco: ${retorno.getString("preco")}")
        println("altura: ${retorno.getString("altura")}")
        println("largura: ${retorno.getString("largura")}")
        println("profundidade: ${retorno.getString("profundidade")}")
    }

    println("Tem certeza que deseja excluir esse registro?")
    val resposta = readln()

    when(resposta) {
        "sim"-> {
            val deletar = banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id = ?")
                deletar.setInt(1, id)//Diz qual é o valor do 1º ponto de interrogação
            deletar.executeUpdate()//manda a introdução para ser executada no banco
        }
        else -> {
            println("Operação cancelada!")
        }
    }
    banco.close()
}