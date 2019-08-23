package br.univille.dsi2019.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.repository.ClienteRepository;
import br.univille.dsi2019.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Cliente cliente) {
		repository.save(cliente);
		
	}
	@Override
	public void delete(Cliente cliente) {
		repository.delete(cliente);
	}
	
	@Override
	public Optional<Cliente> findById(long id) {
		return repository.findById(id);
	}
}
