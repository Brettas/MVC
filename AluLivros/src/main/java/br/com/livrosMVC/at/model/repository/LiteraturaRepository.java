package br.com.livrosMVC.at.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livrosMVC.at.model.domain.Literatura;

import java.util.List;
import java.util.Optional;

@Repository
public interface LiteraturaRepository extends CrudRepository<Literatura, Integer> {
    @Query("from Literatura l where l.usuario.id = :userId order by l.titulo")
    List<Literatura> obterLista(Integer userId);
    
    Optional<Literatura> findById(Integer id);
}
