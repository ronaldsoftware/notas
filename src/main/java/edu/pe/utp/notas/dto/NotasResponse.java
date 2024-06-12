package edu.pe.utp.notas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotasResponse {

    private Integer idUsuario;
    private Integer idCurso;
    private Double nota1;
    private Double nota2;
    private Double nota3;
    private Double nota4;
    private Double promedio;
}
