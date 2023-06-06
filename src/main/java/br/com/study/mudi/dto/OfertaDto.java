package br.com.study.mudi.dto;

import lombok.Data;

@Data
public class OfertaDto {
    
    private Long id;
    private String nome;
    private String valor;
    private String dataEntrega;
    private String comentario;
}
