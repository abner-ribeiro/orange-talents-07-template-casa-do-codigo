package br.com.zup.casaDoCodigo.repository;

import br.com.zup.casaDoCodigo.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    Optional<Categoria> findByNome(String nome);
}
