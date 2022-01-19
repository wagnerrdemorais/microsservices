package com.wagnerrdemorais.loja;

import com.wagnerrdemorais.loja.dto.InfoFornecedorDto;
import com.wagnerrdemorais.loja.dto.InfoPedidoDto;
import com.wagnerrdemorais.loja.dto.ItemCompraDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value ="/pedido")
    InfoPedidoDto realizaPedido(List<ItemCompraDto> itens);
}
