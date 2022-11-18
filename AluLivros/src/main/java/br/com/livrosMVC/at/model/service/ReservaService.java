package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.model.domain.Reserva;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> obterLista(Usuario usuario){
        return reservaRepository.obterLista(usuario.getId());
    }

    public List<Reserva> obterLista(){

        return (List<Reserva>) reservaRepository.findAll();
    }

    public void incluir(Reserva reserva) {

        reservaRepository.save(reserva);
    }

    public void excluir(Integer id) {
        reservaRepository.deleteById(id);
    }

    public Reserva obterPorId(Integer id) {
        return reservaRepository.findById(id).orElse(null);
    }
}
