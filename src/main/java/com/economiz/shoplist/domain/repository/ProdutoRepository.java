package com.economiz.shoplist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.economiz.shoplist.domain.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
