package br.com.zup.casaDoCodigo.repository;

import br.com.zup.casaDoCodigo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
