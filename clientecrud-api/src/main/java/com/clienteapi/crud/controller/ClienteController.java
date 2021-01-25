package com.clienteapi.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clienteapi.crud.model.Cidade;
import com.clienteapi.crud.model.Cliente;
import com.clienteapi.crud.repository.CidadeRepository;
import com.clienteapi.crud.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@GetMapping
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
		
	}
	//Cadastrar cliente
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastrarCidade(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	//Consultar cliente pelo Id
	@ResponseBody
	public String consultaId(@RequestParam Long id) {
	    return "ID: " + id;
	}
	//Consultar cidade pelo nomecompleto
	@ResponseBody
	public String consulnome_completo(@RequestParam String  nome_completo) {
	    return "nome_completo: " + nome_completo;
	}
	
	
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
		clienteRepository.deleteById(id);
    }
	
	
	
}

