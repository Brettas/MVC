package br.com.livrosMVC.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.livrosMVC.at.model.domain.Livro;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.LivroService;

@Controller
public class LivroController {
	
	@Autowired
	private LivroService livroService;

	@GetMapping(value = "/livro/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("livros", livroService.obterLista(usuario));
		
		return "livro/lista";
	}	

	@GetMapping(value = "/livro/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Livro livro = livroService.obterPorId(id);
		
		String mensagem = null;
		try {
			livroService.excluir(id);
			mensagem = "O livro " + livro.getTitulo() + " foi removido com sucesso!";
		} catch (Exception e) {
			mensagem = "Foi impossível realizar a exclusão do livro "+ livro.getTitulo();
		}
		model.addAttribute("msg", mensagem);
		
		return telaLista(model, usuario);
	}
}