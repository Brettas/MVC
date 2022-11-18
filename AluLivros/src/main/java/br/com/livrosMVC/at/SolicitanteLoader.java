package br.com.livrosMVC.at;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.livrosMVC.at.model.domain.Solicitante;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.SolicitanteService;

@Component
@Order(2)
public class SolicitanteLoader implements ApplicationRunner {

	@Autowired
	private SolicitanteService solicitanteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Solicitante solicitante = new Solicitante("Joãozinho", "joao@joao.com", "31828372617");
		solicitante.setUsuario(usuario);
		
		//solicitanteService.incluir(solicitante);
	}
}
