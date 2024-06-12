package edu.pe.utp.notas.service;

import edu.pe.utp.notas.dto.NotasRequest;
import edu.pe.utp.notas.dto.NotasResponse;

import java.util.List;

public interface NotasService {

    NotasResponse crear(NotasRequest notasRequest);
    List<NotasResponse> listar();
}
