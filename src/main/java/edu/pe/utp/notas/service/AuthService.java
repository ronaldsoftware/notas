package edu.pe.utp.notas.service;


import edu.pe.utp.notas.dto.TokenRequest;
import edu.pe.utp.notas.dto.TokenResponse;

public interface AuthService {

    TokenResponse login(TokenRequest tokenRequest);
}
