package br.com.livrosMVC.at.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import br.com.livrosMVC.at.model.domain.Login;
import br.com.livrosMVC.at.model.domain.Usuario;

import java.util.List;

@FeignClient(url = "http://localhost:8081", name = "usuarioClient")
public interface IUsuarioClient {

	@GetMapping(value = "/usuarios")
	List<Usuario> obterLista();

	@PostMapping(value = "/usuarios")
	void incluir(Usuario usuario);

	@DeleteMapping(value = "/usuarios/{id}")
	void excluir(@PathVariable Integer id);

	@PostMapping(value = "/usuarios/autenticar")
	Usuario validar(@RequestBody Login login);
	
	@DeleteMapping(value = "/usuarios/{id}")
	void pegar(@PathVariable Integer id);
}