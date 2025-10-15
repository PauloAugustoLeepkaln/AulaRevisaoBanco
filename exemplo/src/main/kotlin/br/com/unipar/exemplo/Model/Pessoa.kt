package br.com.unipar.exemplo.Model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity //Essa anotação significa que essa classe
data class Pessoa ( //Por padrão deixar como data class
    @Id //Toda classe Entity precisa informar com id
    @GeneratedValue(strategy = GenerationType.AUTO)//Os ids precisam saber o tipo de geração de dados
    val id : Long? = null, //Usamos o valor nulo para informar a JPA que novos objetos serão novas linhas no banco
    val nome : String = "",
    val idade : Int = 0,
    val cpf : String = ""

){
}