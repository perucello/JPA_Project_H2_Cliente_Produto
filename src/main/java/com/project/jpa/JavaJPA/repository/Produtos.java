package com.project.jpa.JavaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.jpa.JavaJPA.model.Produto;

public interface  Produtos  extends JpaRepository<Produto, Long> {

}
