package ProjetoCaixadAgua.Entidades

class Cliente (
    nome: String,
    idade: Int,
    CPF: String,
    telefone: String,
    sexo: Char,
    val email: String,
    val endereco: String,

    ) : Pessoa(
    nome = nome,
    idade = idade,
    CPF = CPF,
    telefone = telefone,
    )

