package edu.pe.utp.notas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String username;
    private String password;
    private String roles;
}
