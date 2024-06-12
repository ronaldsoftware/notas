package edu.pe.utp.notas.controller;

import edu.pe.utp.notas.dto.NotasRequest;
import edu.pe.utp.notas.dto.NotasResponse;
import edu.pe.utp.notas.service.NotasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NotasController {

    private final NotasService notasService;

    @PostMapping("/registrar-nota")
    public ResponseEntity<NotasResponse> registerNota(@Valid @RequestBody NotasRequest notasRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notasService.crear(notasRequest));
    }

    @GetMapping("/listar-nota")
    public ResponseEntity<List<NotasResponse>> listarNota() {
        return ResponseEntity.status(HttpStatus.OK).body(notasService.listar());
    }
}
