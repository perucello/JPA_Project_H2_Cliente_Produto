package com.project.jpa.JavaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.jpa.JavaJPA.model.Cliente;

public interface Clientes extends JpaRepository<Cliente, Long>  {

}
