package edu.pe.utp.notas.service.impl;

import edu.pe.utp.notas.dto.NotasRequest;
import edu.pe.utp.notas.dto.NotasResponse;
import edu.pe.utp.notas.model.Notas;
import edu.pe.utp.notas.repository.NotasRepository;
import edu.pe.utp.notas.service.NotasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class NotasServiceImpl implements NotasService {

    private final NotasRepository notasRepository;

    @Override
    public NotasResponse crear(NotasRequest notasRequest) {

        var promedio = Stream.of(notasRequest.getNota1(), notasRequest.getNota2(),
                        notasRequest.getNota3(), notasRequest.getNota4())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        var notas = Notas.builder()
                .idUsuario(notasRequest.getIdUsuario())
                .idCurso(notasRequest.getIdCurso())
                .nota1(notasRequest.getNota1())
                .nota2(notasRequest.getNota2())
                .nota3(notasRequest.getNota3())
                .nota4(notasRequest.getNota4())
                .promedio(promedio)
                .build();
        notasRepository.save(notas);

        return NotasResponse.builder()
                .idUsuario(notasRequest.getIdUsuario())
                .idCurso(notasRequest.getIdCurso())
                .nota1(notasRequest.getNota1())
                .nota2(notasRequest.getNota2())
                .nota3(notasRequest.getNota3())
                .nota4(notasRequest.getNota4())
                .promedio(promedio)
                .build();
    }

    @Override
    public List<NotasResponse> listar() {
        List<Notas> notaList = notasRepository.findAll();
        return notaList.stream()
                .map(notas -> NotasResponse.builder()
                        .idUsuario(notas.getIdUsuario())
                        .idCurso(notas.getIdCurso())
                        .nota1(notas.getNota1())
                        .nota2(notas.getNota2())
                        .nota3(notas.getNota3())
                        .nota4(notas.getNota4())
                        .promedio(notas.getPromedio())
                        .build())
                .toList();
    }
}
