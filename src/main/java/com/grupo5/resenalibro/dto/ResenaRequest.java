package com.grupo5.resenalibro.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public class ResenaRequest {
    public String externalId;
    public Long usuarioId;
    public String contenido;
    public LocalDateTime fecha;
    @NotNull
    @Min(1)
    @Max(5)
    public Integer puntuacion;

    @NotNull
    @Pattern(regexp = "[BM]", message = "El tipo debe ser B o M")
    private String tipo;
}
