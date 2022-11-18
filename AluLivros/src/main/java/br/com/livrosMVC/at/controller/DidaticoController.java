package br.com.livrosMVC.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.livrosMVC.at.model.domain.Didatico;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.DidaticoService;

@Controller
public class DidaticoController {
    @Autowired
    private DidaticoService didaticoService;

    @GetMapping(value = "/didatico/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("didaticos", didaticoService.obterLista(usuario));

        return "didatico/lista";
    }

    @GetMapping(value = "/didatico")
    public String telaCadastro() {
        return "didatico/cadastro";
    }

    @PostMapping(value = "/didatico/incluir")
    public String incluir(Model model, Didatico didatico, @SessionAttribute("user") Usuario usuario) {

        didatico.setUsuario(usuario);

        didaticoService.incluir(didatico);

        model.addAttribute("msg", "Livro didático " + didatico.getTitulo() + " cadastrado com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/didatico/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Didatico didatico = didaticoService.obterPorId(id);

        didaticoService.excluir(id);

        model.addAttribute("msg", "Livro didático " + didatico.getTitulo() + " removido com sucesso!!!");

        return telaLista(model, usuario);
    }
}
