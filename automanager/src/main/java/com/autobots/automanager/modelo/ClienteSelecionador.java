package com.autobots.automanager.modelo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;

@Component
public class ClienteSelecionador {
	public Cliente selecionar(List<Cliente> clientes, long id) {
		if (clientes == null) {
			return null;
		}
		for (Cliente cliente : clientes) {
			if (cliente != null && cliente.getId() != null) {
				if (cliente.getId().longValue() == id) {
					return cliente;
				}
			}
		}
		return null;
	}
}