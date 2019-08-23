package br.univille.dsi2019.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dsi2019.model.Cliente;
import br.univille.dsi2019.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControllerAPI {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getAll(){
		return new ResponseEntity(clienteService.getAll(),HttpStatus.OK);
	}
	@PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente){
		clienteService.save(cliente);
        return new ResponseEntity(cliente,HttpStatus.OK);
    }
	@PutMapping(path="/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, 
    		@Valid @RequestBody Cliente cliente){
        Optional<Cliente> talvezCliente = clienteService.findById(id);
        if (!talvezCliente.isPresent())
            return ResponseEntity.notFound().build();
        Cliente clienteAntigo = talvezCliente.get();
        clienteAntigo.setNome(cliente.getNome());
        clienteAntigo.setEndereco(cliente.getEndereco());
        clienteAntigo.setDataNascimento(cliente.getDataNascimento());
        clienteAntigo.setCidade(cliente.getCidade());
        clienteService.save(clienteAntigo);
        return new ResponseEntity(clienteAntigo,HttpStatus.OK);
    }
	@DeleteMapping(path="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        Optional<Cliente> talvezCliente = clienteService.findById(id);
        if (!talvezCliente.isPresent())
            return ResponseEntity.notFound().build();
        
        clienteService.delete(talvezCliente.get());
        return ResponseEntity.ok().build();
    }
}
