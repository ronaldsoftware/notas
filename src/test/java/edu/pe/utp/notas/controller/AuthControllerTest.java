package edu.pe.utp.notas.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.pe.utp.notas.config.JwtTokenProvider;
import edu.pe.utp.notas.dto.TokenDto;
import edu.pe.utp.notas.dto.TokenRequest;
import edu.pe.utp.notas.dto.TokenResponse;
import edu.pe.utp.notas.dto.UserRequest;
import edu.pe.utp.notas.service.AuthService;
import edu.pe.utp.notas.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @Mock
    private UserService userService;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthenticateUserSuccess() {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setUsername("user");
        tokenRequest.setPassword("password");

        UserRequest userRequest = UserRequest.builder()
                .username(tokenRequest.getUsername())
                .password(tokenRequest.getPassword())
                .roles("ROLE_ADMIN")
                .build();

        userService.save(userRequest);

        Set<GrantedAuthority> setAuths = new HashSet<>(0);
        setAuths.add(new SimpleGrantedAuthority(userRequest.getRoles()));

        List<GrantedAuthority> authorities = new ArrayList<>(setAuths);

        Authentication authentication = new UsernamePasswordAuthenticationToken("user", "password", authorities);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        TokenDto tokenDto = TokenDto.builder()
                .token("fake-jwt-token")
                .expiryDate(new Date())
                .build();
        when(jwtTokenProvider.generateToken(authentication)).thenReturn(tokenDto);

        when(authService.login(tokenRequest)).thenReturn(new TokenResponse("fake-jwt-token", "Token generated successfully"));

        ResponseEntity<TokenResponse> responseEntity = authController.authenticateUser(tokenRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("fake-jwt-token", responseEntity.getBody().getToken());
    }
}
