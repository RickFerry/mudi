package br.com.study.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.study.mudi.dto.OfertaDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataEntrega;
    private String comentario;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public Oferta(OfertaDto dto) {
        this.comentario = dto.getComentario();
        this.dataEntrega = LocalDate.parse(dto.getDataEntrega(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.valor = new BigDecimal(dto.getValor());
    }
}
