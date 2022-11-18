package br.com.livrosMVC.at.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livrosMVC.at.clients.IEnderecoClient;
import br.com.livrosMVC.at.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco obterCep(String cep) {
		return enderecoClient.obterCep(cep);
	}
}