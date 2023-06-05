package br.com.study.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.mudi.model.Pedido;
import br.com.study.mudi.model.StatusPedido;
import br.com.study.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

    @Autowired
    private PedidoRepository produtoRepository;

    @GetMapping("aguardando")
    public List<Pedido> buscaPorAguardando() {
        Sort sort = Sort.by("id").ascending();
        PageRequest page = PageRequest.of(0, 5, sort);
        return produtoRepository.findByStatus(StatusPedido.AGUARDANDO, page);
    }
}
