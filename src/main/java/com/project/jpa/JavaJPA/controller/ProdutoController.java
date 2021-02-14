package com.project.jpa.JavaJPA.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jpa.JavaJPA.model.Produto;
import com.project.jpa.JavaJPA.repository.Produtos;

@RestController
@RequestMapping("api/JPA/produtos")
public class ProdutoController {
	
	@Autowired
	private Produtos produtos;
	
	
	@GetMapping
	public List<Produto> listarProd(){
		System.out.println("Quantidade de Registros de Produto : " + produtos.count());
		return (produtos.findAll());
	} 
	
	@PostMapping("/add")
	public Produto adicionarProd(@Valid @RequestBody Produto produto) {	
		return produtos.save(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> buscarProd(@PathVariable Long id){
		Optional<Produto> prod = produtos.findById(id);
		if (produtos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(prod);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarProd(@PathVariable Long id, @Valid @RequestBody Produto produto)
	{
		Object atualizar = produtos.findById(id);
		if (atualizar == null) {
			return ResponseEntity.notFound().build();
		}		
		BeanUtils.copyProperties(produto, atualizar, "id");		
		atualizar = produtos.save(produto);	
		return ResponseEntity.ok(atualizar);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProd(@PathVariable Long id){
		Optional<Produto> cliente = produtos.findById(id);
		if(cliente != null) {
			produtos.deleteById(id);
		}
		return ResponseEntity.noContent().build();
	}
	
	
}
