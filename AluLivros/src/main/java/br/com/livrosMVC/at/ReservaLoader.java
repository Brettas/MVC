package br.com.livrosMVC.at;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.livrosMVC.at.model.domain.*;
import br.com.livrosMVC.at.model.service.ReservaService;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class ReservaLoader implements ApplicationRunner {
	
	@Autowired
	private ReservaService reservaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Solicitante solicitante = new Solicitante();
		solicitante.setId(1);

		Literatura l1 = new Literatura();
		l1.setId(1);

		Didatico d1 = new Didatico();
		d1.setId(2);
		
		List<Livro> livros = new ArrayList<>();
		livros.add(l1);
		livros.add(d1);
		
		Reserva reserva = new Reserva();
		reserva.setObservacao("Minha reserva especial");
		reserva.setLivros(livros);
		reserva.setSolicitante(solicitante);
		reserva.setUsuario(usuario);
		
		//reservaService.incluir(reserva);
	}
}