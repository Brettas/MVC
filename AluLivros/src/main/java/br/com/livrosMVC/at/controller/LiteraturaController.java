package br.com.livrosMVC.at.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.livrosMVC.at.model.domain.Literatura;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.LiteraturaService;

@Controller
public class LiteraturaController {
    @Autowired
    private LiteraturaService literaturaService;

    @GetMapping(value = "/literatura/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("literaturas", literaturaService.obterLista(usuario));

        return "literatura/lista";
    }

    @GetMapping(value = "/literatura")
    public String telaCadastro() {
        return "literatura/cadastro";
    }

    @PostMapping(value = "/literatura/incluir")
    public String incluir(Model model, Literatura literatura, @SessionAttribute("user") Usuario usuario) {

        literatura.setUsuario(usuario);

        literaturaService.incluir(literatura);

        model.addAttribute("msg", "Livro de literatura " + literatura.getTitulo() + " cadastrado com sucesso!!!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/literatura/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Literatura literatura = literaturaService.obterPorId(id);

        literaturaService.excluir(id);

        model.addAttribute("msg", "Livro de literatura " + literatura.getTitulo() + " removido com sucesso!!!");

        return telaLista(model, usuario);
    }
    
    @GetMapping(value = "/literatura/{id}/editar")
    public String editar(Model model, @PathVariable Integer id,@SessionAttribute("user") Usuario usuario) {
    	Literatura newLit = new Literatura();
        Literatura lit = literaturaService.obterPorId(id);
        lit.setUsuario(usuario);
        model.addAttribute("lit", lit);
        newLit.setId(id.intValue());
        newLit.setAutor(lit.getAutor());
        newLit.setTitulo(lit.getTitulo());
        newLit.setUsado(lit.isUsado());
        newLit.setGenero(lit.getGenero());
        newLit.setIdioma(lit.getIdioma());
        newLit.setValorAluguel(lit.getValorAluguel());
        newLit.setTipo(lit.getTipo());
        
        return "literatura/detalhes" ;
    }
}
