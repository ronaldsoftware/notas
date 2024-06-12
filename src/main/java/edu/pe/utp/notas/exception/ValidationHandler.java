package edu.pe.utp.notas.exception;

import edu.pe.utp.notas.dto.ErrorCustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCustomResponse> handleException(Exception e) {
        log.error("stackTrace:", e);
        ErrorCustomResponse errorCustomResponse = new ErrorCustomResponse();
        errorCustomResponse.setCode(HttpStatus.BAD_REQUEST.value() + "");
        errorCustomResponse.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorCustomResponse.setDetail(e.getMessage());
        return ResponseEntity.internalServerError().body(errorCustomResponse);
    }
}
