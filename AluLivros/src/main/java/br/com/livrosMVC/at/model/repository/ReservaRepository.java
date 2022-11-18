package br.com.livrosMVC.at.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.livrosMVC.at.model.domain.Reserva;

import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer> {
    @Query("from Reserva r where r.usuario.id = :userId order by r.id")
    List<Reserva> obterLista(Integer userId);
}
