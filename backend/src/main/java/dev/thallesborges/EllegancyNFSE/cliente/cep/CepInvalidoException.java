package dev.thallesborges.EllegancyNFSE.cliente.cep;

public class CepInvalidoException extends RuntimeException {
    public CepInvalidoException(String message) {
        super(message);
    }
}