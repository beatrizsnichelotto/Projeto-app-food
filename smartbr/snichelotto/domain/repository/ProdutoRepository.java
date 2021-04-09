package com.smartbr.snichelotto.domain.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import com.smartbr.snichelotto.domain.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

	
	ResponseEntity<Produto> excluir(Long produtoId);

	Produto findByNome(String nome);


}
