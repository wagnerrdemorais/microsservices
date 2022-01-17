package com.wagnerrdemorais.loja.service;

import com.wagnerrdemorais.loja.dto.CompraDto;
import com.wagnerrdemorais.loja.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    public void realizaCompra(CompraDto compraDto) {

        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://fornecedor/info/" + compraDto.getEndereco().getEstado(),
                    HttpMethod.GET,
                    null,
                    InfoFornecedorDto.class);

        System.out.println(exchange.getBody().getEndereco());

    }
}
