package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.model.domain.Literatura;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.repository.LiteraturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LiteraturaService {
    @Autowired
    private LiteraturaRepository literaturaRepository;

    public List<Literatura> obterLista(Usuario usuario){
        return literaturaRepository.obterLista(usuario.getId());
    }
    public List<Literatura> obterLista(){
        return (List<Literatura>) literaturaRepository.findAll();
    }

    public void incluir(Literatura literatura) {
        literaturaRepository.save(literatura);
    }

    public void excluir(Integer id) {
        literaturaRepository.deleteById(id);
    }

    public Literatura obterPorId(Integer id) {
        return literaturaRepository.findById(id).orElse(null);
    }
    
    public Optional<Literatura> obterId(Integer id) {
        return literaturaRepository.findById(id);
    }
    
    public Literatura salvar(Literatura literatura) {
    	return literaturaRepository.save(literatura);
    }

}
