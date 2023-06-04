package br.com.study.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.study.mudi.dto.RequisicaoNovoPedido;
import br.com.study.mudi.model.Pedido;
import br.com.study.mudi.model.User;
import br.com.study.mudi.repository.PedidoRepository;
import br.com.study.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private static final String FORMULARIO = "pedido/formulario";

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return FORMULARIO;
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return FORMULARIO;
        }
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Pedido pedido = new Pedido(requisicao);
        pedido.setUser(user);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
