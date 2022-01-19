package com.wagnerrdemorais.fornecedor.service;

import java.util.List;

import com.wagnerrdemorais.fornecedor.model.Produto;
import com.wagnerrdemorais.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	
}
