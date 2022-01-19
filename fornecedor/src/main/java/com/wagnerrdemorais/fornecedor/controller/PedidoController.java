package com.wagnerrdemorais.fornecedor.controller;

import com.wagnerrdemorais.fornecedor.dto.ItemDoPedidoDTO;
import com.wagnerrdemorais.fornecedor.model.Pedido;
import com.wagnerrdemorais.fornecedor.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	private static final Logger log = LoggerFactory.getLogger(PedidoController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		log.info("pedido recebido ");
		return pedidoService.realizaPedido(produtos);
	}
	
	@RequestMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
