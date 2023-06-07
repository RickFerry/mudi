package br.com.study.mudi.api;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.mudi.dto.OfertaDto;
import br.com.study.mudi.model.Oferta;
import br.com.study.mudi.model.Pedido;
import br.com.study.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody OfertaDto dto) {
        Pedido p = pedidoRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        
        Oferta nova = new Oferta(dto);
        nova.setPedido(p);
        p.getOfertas().add(nova);
        pedidoRepository.save(p);
        return nova;
    }
}
