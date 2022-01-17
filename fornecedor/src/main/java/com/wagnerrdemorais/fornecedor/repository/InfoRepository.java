package com.wagnerrdemorais.fornecedor.repository;

import com.wagnerrdemorais.fornecedor.model.InfoFornecedor;
import org.springframework.data.repository.CrudRepository;

public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
    InfoFornecedor findByEstado(String estado);
}
