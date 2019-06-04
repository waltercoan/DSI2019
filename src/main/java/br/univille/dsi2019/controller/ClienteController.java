package br.univille.dsi2019.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Cliente> lista = clienteService.getAll();
		return new ModelAndView("cliente/index", "clientes", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Cliente cliente) {
		return new ModelAndView("cliente/form");
	} 
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Cliente cliente)
	{
		clienteService.save(cliente);
		return new ModelAndView("redirect:/cliente");
	}
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Cliente cliente) {
		return new ModelAndView("cliente/form","cliente",cliente);
	}
	
	
}
