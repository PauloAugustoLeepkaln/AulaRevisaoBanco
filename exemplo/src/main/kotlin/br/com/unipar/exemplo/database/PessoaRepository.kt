package br.com.unipar.exemplo.database

import br.com.unipar.exemplo.Model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long> {
}