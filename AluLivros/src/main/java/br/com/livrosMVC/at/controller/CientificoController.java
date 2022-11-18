package br.com.livrosMVC.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.livrosMVC.at.model.domain.Cientifico;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.CientificoService;

@Controller
public class CientificoController {


    @Autowired
    private CientificoService cientificoService;

    @GetMapping(value = "/cientifico/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("cientificos", cientificoService.obterLista(usuario));

        return "cientifico/lista";
    }

    @GetMapping(value = "/cientifico")
    public String telaCadastro() {
        return "cientifico/cadastro";
    }

    @PostMapping(value = "/cientifico/incluir")
    public String incluir(Model model, Cientifico cientifico, @SessionAttribute("user") Usuario usuario) {

        cientifico.setUsuario(usuario);

        cientificoService.incluir(cientifico);

        model.addAttribute("msg", "Livro científico " + cientifico.getTitulo() + " cadastrado com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/cientifico/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Cientifico cientifico = cientificoService.obterPorId(id);

        cientificoService.excluir(id);

        model.addAttribute("msg", "Livro científico " + cientifico.getTitulo() + " removido com sucesso!!!");

        return telaLista(model, usuario);
    }
}
