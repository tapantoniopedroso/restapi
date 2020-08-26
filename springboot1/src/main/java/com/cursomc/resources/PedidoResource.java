package com.cursomc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cursomc.domain.Categoria;
import com.cursomc.domain.Pedido;
import com.cursomc.dto.CategoriaDTO;
import com.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	@Autowired
	PedidoService service;
	
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	//ResponseEntity<?> retorna um objeto com todo o conteudo REST necessario para uma chamada HTTP
	public ResponseEntity<?> find(@PathVariable Integer id) { // @PathVariable para receber o valor vindo no /{id}
		
		Pedido ped = service.find(id);
		
		return ResponseEntity.ok().body(ped);
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
		
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	
	}
}
