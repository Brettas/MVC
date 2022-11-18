package br.com.apiusuarios.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apiusuarios.model.domain.Login;
import br.com.apiusuarios.model.domain.Usuario;
import br.com.apiusuarios.model.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(Login login) {

        return usuarioRepository.autenticacao(login.getEmail(), login.getSenha());
    }

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
    
}
