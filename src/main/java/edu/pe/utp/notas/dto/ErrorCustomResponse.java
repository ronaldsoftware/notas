package edu.pe.utp.notas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorCustomResponse {

    private String code;
    private String message;
    private String detail;

}
