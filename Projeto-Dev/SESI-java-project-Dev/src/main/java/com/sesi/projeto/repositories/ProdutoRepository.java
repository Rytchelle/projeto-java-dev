package com.sesi.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.projeto.entities.Produto;

@Repository	
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
