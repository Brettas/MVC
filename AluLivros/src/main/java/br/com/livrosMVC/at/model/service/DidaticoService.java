package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.model.domain.Didatico;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.repository.DidaticoRepository;

import java.util.List;

@Service
public class DidaticoService {
    @Autowired
    private DidaticoRepository didaticoRepository;

    public List<Didatico> obterLista(Usuario usuario){
        return didaticoRepository.obterLista(usuario.getId());
    }
    public List<Didatico> obterLista(){
        return (List<Didatico>) didaticoRepository.findAll();
    }

    public void incluir(Didatico didatico) {
        didaticoRepository.save(didatico);
    }

    public void excluir(Integer id) {
        didaticoRepository.deleteById(id);
    }

    public Didatico obterPorId(Integer id) {
        return didaticoRepository.findById(id).orElse(null);
    }
}
