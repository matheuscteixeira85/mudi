package br.com.pontocom.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pontocom.mvc.mudi.model.Pedido;
import br.com.pontocom.mvc.mudi.model.StatusPedido;
import br.com.pontocom.mvc.mudi.repository.PedidoRepository;

@Controller
public class IndexController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping("home")
	public String home(Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos",pedidos);
		
		return "home";
	}
	
	@GetMapping("home/{status}")
	public String aguardando(@PathVariable("status") String status,Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findAllByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos",pedidos);
		model.addAttribute("status",status);
		
		return "home";
	}
	

}
