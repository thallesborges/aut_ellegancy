package dev.thallesborges.EllegancyNFSE.cliente;

import jakarta.validation.constraints.NotBlank;

public record CadastrarClienteRequest (
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String cep,
        @NotBlank
        String numero_residencia
) {}
