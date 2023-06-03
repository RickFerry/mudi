package br.com.study.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.study.mudi.dto.RequisicaoNovoPedido;
import br.com.study.mudi.model.Pedido;
import br.com.study.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    private static final String FORMULARIO = "pedido/formulario";

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return FORMULARIO;
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return FORMULARIO;
        }
        pedidoRepository.save(new Pedido(requisicao));
        return "redirect:/home";
    }
}
