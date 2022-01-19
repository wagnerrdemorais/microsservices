package com.wagnerrdemorais.loja.service;

import com.wagnerrdemorais.loja.FornecedorClient;
import com.wagnerrdemorais.loja.dto.CompraDto;
import com.wagnerrdemorais.loja.dto.InfoFornecedorDto;
import com.wagnerrdemorais.loja.dto.InfoPedidoDto;
import com.wagnerrdemorais.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    private static final Logger log = LoggerFactory.getLogger(CompraService.class);

    public Compra realizaCompra(CompraDto compraDto) {

        log.info("buscando informações do fornecedor de: " + compraDto.getEndereco().getEstado());

        InfoFornecedorDto infoPorEstado = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        log.info("realizando pedido");
        InfoPedidoDto infoPedidoDto = fornecedorClient.realizaPedido(compraDto.getItens());


        Compra compra = new Compra();
        compra.setPedidoId(infoPedidoDto.getId());
        compra.setTempoPreparo(infoPedidoDto.getTempoPreparo());
        compra.setEnderecoDestino(compraDto.getEndereco().toString());

        System.out.println(infoPorEstado.getEndereco());

        return compra;
    }
}
