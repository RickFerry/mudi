package br.com.study.mudi.dto;

import jakarta.validation.constraints.NotBlank;

public record RequisicaoNovoPedido(
    
    @NotBlank String nomeProduto,
    @NotBlank String urlProduto,
    @NotBlank String urlImagem,
    String descricao
) {}
