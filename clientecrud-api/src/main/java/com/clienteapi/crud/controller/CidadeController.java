package com.clienteapi.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clienteapi.crud.model.Cidade;
import com.clienteapi.crud.repository.CidadeRepository;

@RestController
@RequestMapping({"/cidades"})
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	CidadeController (CidadeRepository cidadeRepository){
		this.cidadeRepository = cidadeRepository;
	}
	
	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
		
	}
	
	@ResponseBody
	public String consultaId(@RequestParam Long id) {
	    return "ID: " + id;
	}
	//Consultar cidade pelo nome
	@ResponseBody
	public String consultaName(@RequestParam String  name) {
	    return "name: " + name;
	}
	//Consultar cidade pelo estado
	@ResponseBody
	public String consultaEstado(@RequestParam String  estado) {
	    return "estado: " + estado;
	}
	//Cadastrar cidade
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade cadastrarCidade(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
		
	}
	
		
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
		cidadeRepository.deleteById(id);
    }

}
