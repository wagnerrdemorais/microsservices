package com.wagnerrdemorais.fornecedor.service;

import com.wagnerrdemorais.fornecedor.model.InfoFornecedor;
import com.wagnerrdemorais.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoFornecedor getInfoPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}
}
