package br.com.study.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.study.mudi.model.StatusPedido;
import br.com.study.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository produtoRepository;

	@GetMapping
	public String home(Model model) {
		Sort sort = Sort.by("dataEntrega").ascending();
		PageRequest page = PageRequest.of(0, 5, sort);
		model.addAttribute("pedidos", produtoRepository.findByStatus(StatusPedido.ENTREGUE, page));
		return "home";
	}
}
