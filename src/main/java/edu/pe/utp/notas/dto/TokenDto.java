package edu.pe.utp.notas.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TokenDto {

    private String token;
    private Date expiryDate;
}
