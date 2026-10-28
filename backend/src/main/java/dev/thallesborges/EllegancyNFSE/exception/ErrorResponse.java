package dev.thallesborges.EllegancyNFSE.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        Integer status,
        String message,
        LocalDateTime timestamp
) {}