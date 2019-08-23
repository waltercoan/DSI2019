package br.univille.dsi2019.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.Cliente;

@Service
public interface ClienteService {
	List<Cliente> getAll();
	void save(Cliente cliente);
	void delete(Cliente cliente);
	Optional<Cliente> findById(long id);
}
