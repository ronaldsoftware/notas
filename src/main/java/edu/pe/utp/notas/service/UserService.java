package edu.pe.utp.notas.service;


import edu.pe.utp.notas.dto.UserRequest;
import edu.pe.utp.notas.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String username);

    UserRequest save(UserRequest userRequest);
}
