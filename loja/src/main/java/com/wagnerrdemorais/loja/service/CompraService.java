package com.wagnerrdemorais.loja.service;

import com.wagnerrdemorais.loja.FornecedorClient;
import com.wagnerrdemorais.loja.dto.CompraDto;
import com.wagnerrdemorais.loja.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void realizaCompra(CompraDto compraDto) {

        InfoFornecedorDto infoPorEstado = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        System.out.println(infoPorEstado.getEndereco());

    }
}
