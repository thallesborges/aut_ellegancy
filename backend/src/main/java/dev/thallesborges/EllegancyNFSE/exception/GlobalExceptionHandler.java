package dev.thallesborges.EllegancyNFSE.exception;

import dev.thallesborges.EllegancyNFSE.cliente.cep.CepInvalidoException;
import dev.thallesborges.EllegancyNFSE.cliente.cpf.CpfInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<ErrorResponse> buildError(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(
                new ErrorResponse(
                        status.value(),
                        message,
                        LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceExistenteException(ResourceExistenteException ex) {
        return buildError(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCpfInvalidoException(CpfInvalidoException ex) {
        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCepInvalidoException(CepInvalidoException ex) {
        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
