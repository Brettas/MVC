package br.com.livrosMVC.at.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.livrosMVC.at.model.domain.Livro;
import br.com.livrosMVC.at.model.domain.Reserva;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.LivroService;
import br.com.livrosMVC.at.model.service.ReservaService;
import br.com.livrosMVC.at.model.service.SolicitanteService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private SolicitanteService solicitanteService;
    @Autowired
    private LivroService livroService;

    @GetMapping(value = "/reserva")
    public String tela(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("solicitantes", solicitanteService.obterLista(usuario));

        model.addAttribute("livros", livroService.obterLista(usuario));

        return "reserva/cadastro";
    }

    @GetMapping(value = "/reserva/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("lista", reservaService.obterLista(usuario));

        return "reserva/lista";
    }

    @PostMapping(value = "/reserva/incluir")
    public String incluir(Model model, Reserva reserva, @RequestParam String[] livrosId, @SessionAttribute("user") Usuario usuario) {

        List<Livro> livros = new ArrayList<>();

        for(String id : livrosId) {
            livros.add(livroService.obterPorId(Integer.valueOf(id)));
        }

        reserva.setLivros(livros);

        reserva.setUsuario(usuario);

        reservaService.incluir(reserva);

        String mensagem = "A reserva "+ reserva.obterReserva() +" foi cadastrada com sucesso!!!";

        model.addAttribute("msg", mensagem);

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/reserva/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

        Reserva reserva = reservaService.obterPorId(id);

        reservaService.excluir(id);

        String mensagem = "A reserva "+ reserva.obterReserva() +" foi removida com sucesso!!!";

        model.addAttribute("msg", mensagem);

        return telaLista(model, usuario);
    }
}
