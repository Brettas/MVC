package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.clients.IUsuarioClient;
import br.com.livrosMVC.at.model.domain.Login;
import br.com.livrosMVC.at.model.domain.Usuario;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioClient usuarioClient;

    public Usuario validar(String email, String senha) {

        return usuarioClient.validar(new Login(email, senha));
    }

    public void incluir(Usuario usuario) {
        usuarioClient.incluir(usuario);
    }

    public void excluir(Integer id) {
        usuarioClient.excluir(id);
    }

    public List<Usuario> obterLista(){
        return usuarioClient.obterLista();
    }

	public void consultarUsuario(Integer id) {
		usuarioClient.pegar(id);
		
	}
}
