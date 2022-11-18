package br.com.livrosMVC.at.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livrosMVC.at.model.domain.Cientifico;

import java.util.List;

@Repository
public interface CientificoRepository extends CrudRepository<Cientifico, Integer> {
    @Query("from Cientifico c where c.usuario.id = :userId order by c.titulo")
    List<Cientifico> obterLista(Integer userId);
}
