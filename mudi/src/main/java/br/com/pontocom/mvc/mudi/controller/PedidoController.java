package br.com.pontocom.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pontocom.mvc.mudi.dto.PedidoDto;
import br.com.pontocom.mvc.mudi.model.Pedido;
import br.com.pontocom.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(PedidoDto pedidoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDto pedidoDto, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = pedidoDto.toPedido();
		pedidoRepository.save(pedido);
		return "home";
	}

}
