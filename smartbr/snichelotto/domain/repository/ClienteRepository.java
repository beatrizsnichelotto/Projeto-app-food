package com.smartbr.snichelotto.domain.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.smartbr.snichelotto.domain.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);

	List<Cliente> findByNomeContaining(String nome);

	Cliente findByCpf(String cpf);
}