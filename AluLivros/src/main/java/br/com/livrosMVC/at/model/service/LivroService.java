package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.model.domain.Livro;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.repository.LivroRepository;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> obterLista(Usuario usuario){
        return (List<Livro>) livroRepository.obterLista(usuario.getId());
    }
    public List<Livro> obterLista(){
        return (List<Livro>) livroRepository.findAll();
    }

    public void excluir(Integer id) {
        livroRepository.deleteById(id);
    }

    public Livro obterPorId(Integer id) {
        return livroRepository.findById(id).orElse(null);
    }
}
