package br.com.unipar.exemplo.Controller

import br.com.unipar.exemplo.Model.Pessoa
import br.com.unipar.exemplo.database.PessoaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//A anotação RestController não pode usar, basicamente é para construir APIs
//Já a anotação Controller permite ter VIEW
@RestController
@RequestMapping("/pessoa")
class PessoaController(
    private val pessoaRepository: PessoaRepository
    /**Uma injeção de dependência é necessária quando
     * usamos uma classe externa, essa injeção (variável)
     * deve ser privada, por uma questão de segurança.
     */
) {
    @PostMapping
    fun cadastrarPessoa(@RequestBody pessoa: Pessoa)
            : ResponseEntity<Pessoa> {
        println("BOSTA")
        return ResponseEntity.ok(
            pessoaRepository.save<Pessoa>(pessoa))
    }
    @GetMapping
    fun listarPessoas() : List<Pessoa>{
        return pessoaRepository.findAll()
    }
    @GetMapping
    fun buscarPessoas() : ResponseEntity<List<Pessoa>>{
        return ResponseEntity.ok(pessoaRepository.findAll())
    }
    @GetMapping("/{id}")
    fun buscarId(@PathVariable id : Long) : ResponseEntity<List<Pessoa>>{
        return ResponseEntity.ok(pessoaRepository.findAll())
    }
}