package br.com.apiusuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.com.apiusuarios.model.domain.Login;
import br.com.apiusuarios.model.domain.Usuario;
import br.com.apiusuarios.model.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        try {
            return usuarioService.listar();
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping
    public void incluir(@RequestBody Usuario usuario) {
        try {
            usuarioService.incluir(usuario);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable Integer id) {
        try {
            usuarioService.excluir(id);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping(value = "/autenticar")
    public Usuario autenticar(@RequestBody Login login) {
        try {
            return usuarioService.autenticar(login);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
