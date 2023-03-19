package br.com.study.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.study.mudi.dto.RequisicaoNovoPedido;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    public Pedido(RequisicaoNovoPedido requisicao) {
        this.nomeProduto = requisicao.nomeProduto();
        this.urlImagem = requisicao.urlImagem();
        this.urlProduto = requisicao.urlProduto();
        this.descricao = requisicao.descricao();
        this.status = StatusPedido.AGUARDANDO;
    }
}
