package com.autobots.automanager.modelo;

import com.autobots.automanager.entidades.Cliente;

public class ClienteAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();
	private DocumentoAtualizador documentoAtualizador = new DocumentoAtualizador();
	private TelefoneAtualizador telefoneAtualizador = new TelefoneAtualizador();

	private void atualizarDados(Cliente cliente, Cliente atualizacao) {
		if (!verificador.verificar(atualizacao.getNome())) {
			cliente.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getNomeSocial())) {
			cliente.setNomeSocial(atualizacao.getNomeSocial());
		}
		if (!(atualizacao.getDataCadastro() == null)) {
			cliente.setDataCadastro(atualizacao.getDataCadastro());
		}
		if (!(atualizacao.getDataNascimento() == null)) {
			cliente.setDataNascimento(atualizacao.getDataNascimento());
		}
	}

	public void atualizar(Cliente cliente, Cliente atualizacao) {
		atualizarDados(cliente, atualizacao);
	
		if (cliente.getEndereco() == null) {
			if (atualizacao.getEndereco() != null) {
				cliente.setEndereco(atualizacao.getEndereco());
			}
		} else {
			enderecoAtualizador.atualizar(cliente.getEndereco(), atualizacao.getEndereco());
		}
		
		if ((cliente.getDocumentos() == null || cliente.getDocumentos().isEmpty())) {
			if (atualizacao.getDocumentos() != null && !atualizacao.getDocumentos().isEmpty()) {
				cliente.setDocumentos(atualizacao.getDocumentos());
			}
		} else if (atualizacao.getDocumentos() != null) {
			documentoAtualizador.atualizar(cliente.getDocumentos(), atualizacao.getDocumentos());
		}
	
		if ((cliente.getTelefones() == null || cliente.getTelefones().isEmpty())) {
			if (atualizacao.getTelefones() != null && !atualizacao.getTelefones().isEmpty()) {
				cliente.setTelefones(atualizacao.getTelefones());
			}
		} else if (atualizacao.getTelefones() != null) {
			telefoneAtualizador.atualizar(cliente.getTelefones(), atualizacao.getTelefones());
		}
	}
}
