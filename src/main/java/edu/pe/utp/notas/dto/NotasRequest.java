package edu.pe.utp.notas.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class NotasRequest {

    @NotNull(message = "El atributo idUsuario no debe ser nulo")
    private Integer idUsuario;

    @NotNull(message = "El atributo idCurso no debe ser nulo")
    private Integer idCurso;

    @NotNull(message = "El atributo nota1 no debe ser nulo")
    private Double  nota1;

    @NotNull(message = "El atributo nota2 no debe ser nulo")
    private Double  nota2;

    @NotNull(message = "El atributo nota3 no debe ser nulo")
    private Double  nota3;

    @NotNull(message = "El atributo nota4 no debe ser nulo")
    private Double  nota4;

}
