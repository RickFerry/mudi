package br.com.study.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.study.mudi.dto.RequisicaoNovoPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido(RequisicaoNovoPedido requisicao) {
        this.nomeProduto = requisicao.getNomeProduto();
        this.urlImagem = requisicao.getUrlImagem();
        this.urlProduto = requisicao.getUrlProduto();
        this.descricao = requisicao.getDescricao();
        this.status = StatusPedido.AGUARDANDO;
    }
}
