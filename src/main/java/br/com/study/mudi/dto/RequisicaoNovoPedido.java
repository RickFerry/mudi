package br.com.study.mudi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImagem;
    
    private String descricao;
}
