package br.com.study.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class OfertaDto {
    
    private Long id;
    private String nome;

    @NotBlank
    @Pattern(regexp = "^\\d+(\\.\\d{2})?$")
    private String valor;
    
    @NotBlank
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    private String dataEntrega;

    private String comentario;
}
