package br.com.study.mudi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.study.mudi.model.StatusPedido;
import br.com.study.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository produtoRepository;

	@GetMapping
	public String home(Model model, Principal principal) {
		model.addAttribute("pedidos", produtoRepository.findAllByUsuario(principal.getName()));
		return "home";
	}

	@GetMapping("/{status}")
	public String porStatus(@PathVariable String status, Model model) {
		model.addAttribute("pedidos", produtoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase())));
		model.addAttribute("status", status);
		return "home";
	}
}
