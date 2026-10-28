package dev.thallesborges.EllegancyNFSE.cliente;

import java.time.Instant;

public record ClienteResponse(
        Long id,
        String nome,
        String cpf,
        String cep,
        String numero_residencia,
        Boolean ativo,
        Instant criado_em,
        Instant atualizado_em
) {}
