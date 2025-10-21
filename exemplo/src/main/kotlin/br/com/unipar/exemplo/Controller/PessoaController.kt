package br.com.unipar.exemplo.Controller

import br.com.unipar.exemplo.Model.Pessoa
import br.com.unipar.exemplo.database.PessoaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//A anotação RestController não pode usar, basicamente é para construir APIs
//Já a anotação Controller permite ter VIEW
@CrossOrigin(origins = ["https://localhost:5173"])
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
            pessoaRepository.save<Pessoa>(pessoa)
        )
    }

    @GetMapping
    fun buscarPessoas(): ResponseEntity<List<Pessoa>> {
        return ResponseEntity.ok(pessoaRepository.findAll())
    }

    @GetMapping("/{id}")
    fun buscarId(@PathVariable("id") id: Long): ResponseEntity<Pessoa> {
        val pessoa: Pessoa = pessoaRepository.findById(id).get()
        return if (pessoa != null) {
            ResponseEntity.ok(pessoa)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun excluirPessoa(@PathVariable id : Long): ResponseEntity<Void> {
            return if (pessoaRepository.existsById(id)) {
                pessoaRepository.deleteById(id)
                ResponseEntity.noContent().build()
            } else {
                ResponseEntity.notFound().build()
            }
        }

    @PutMapping("/{id}")
    fun atualizarPessoa(@PathVariable id:Long, @RequestBody novaPessoa : Pessoa)
        : ResponseEntity<Pessoa> {
            return pessoaRepository.findById(id).map { pessoa ->
                val pessoaAtualiza = pessoa.copy(
                    nome = novaPessoa.nome,
                    idade = novaPessoa.idade,
                    cpf = novaPessoa.cpf,
                )
                ResponseEntity.ok(pessoaRepository.save(novaPessoa))
            }.orElse (
                ResponseEntity.notFound().build()
            )

        }
}