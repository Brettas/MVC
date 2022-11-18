package br.com.livrosMVC.at.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livrosMVC.at.model.domain.Didatico;

import java.util.List;

@Repository
public interface DidaticoRepository extends CrudRepository<Didatico, Integer> {
    @Query("from Didatico d where d.usuario.id = :userId order by d.titulo")
    List<Didatico> obterLista(Integer userId);
}
