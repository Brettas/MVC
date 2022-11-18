package br.com.livrosMVC.at;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.livrosMVC.at.model.domain.Cientifico;
import br.com.livrosMVC.at.model.domain.Didatico;
import br.com.livrosMVC.at.model.domain.Literatura;
import br.com.livrosMVC.at.model.domain.Usuario;
import br.com.livrosMVC.at.model.service.CientificoService;
import br.com.livrosMVC.at.model.service.DidaticoService;
import br.com.livrosMVC.at.model.service.LiteraturaService;

@Component
@Order(3)
public class LivroLoader implements ApplicationRunner {
	
	@Autowired
	private LiteraturaService literaturaService;
	@Autowired
	private DidaticoService didaticoService;
	@Autowired
	private CientificoService cientificoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setId(1);

		Literatura l1 = new Literatura();
		l1.setTitulo("Memórias Póstumas de Brás Cubas");
		l1.setAutor("Machado de Assis");
		l1.setUsado(true);
		l1.setIdioma("Português");
		l1.setGenero("Romance");
		l1.setUsuario(usuario);

		//literaturaService.incluir(l1);

		Didatico d1 = new Didatico();
		d1.setAutor("James Stewart");
		d1.setTitulo("Cálculo I");
		d1.setUsado(false);
		d1.setDisciplina("Cálculo");
		d1.setConservado(true);
		d1.setSerie("Faculdade");
		d1.setUsuario(usuario);
		
		//didaticoService.incluir(d1);

		Cientifico c1 = new Cientifico();
		c1.setTitulo("Um livro científico ai");
		c1.setAutor("Alberth");
		c1.setRamo("Biológicas");
		c1.setVolumes(5);
		c1.setUsado(true);
		c1.setUsuario(usuario);

		//cientificoService.incluir(c1);
	}
}