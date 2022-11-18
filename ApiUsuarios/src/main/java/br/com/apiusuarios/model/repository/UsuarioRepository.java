package br.com.apiusuarios.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.apiusuarios.model.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("from Usuario u where u.email = :email and u.senha = :senha")
    Usuario autenticacao(String email, String senha);
}
