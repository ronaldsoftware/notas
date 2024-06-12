package edu.pe.utp.notas.service.impl;

import edu.pe.utp.notas.Util.DateUtil;
import edu.pe.utp.notas.config.JwtTokenProvider;
import edu.pe.utp.notas.dto.LoginRequest;
import edu.pe.utp.notas.dto.TokenRequest;
import edu.pe.utp.notas.dto.TokenResponse;
import edu.pe.utp.notas.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public TokenResponse login(TokenRequest tokenRequest) {

        var loginRequest = LoginRequest.builder()
                .username(tokenRequest.getUsername())
                .password(tokenRequest.getPassword()).build();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var token = tokenProvider.generateToken(authentication);
        return TokenResponse.builder().token(token.getToken())
                .expiracion(DateUtil.formatDate(token.getExpiryDate())).build();
    }
}
