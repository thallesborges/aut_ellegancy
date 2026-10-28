package dev.thallesborges.EllegancyNFSE.cliente.cpf;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String message) {
        super(message);
    }
}
