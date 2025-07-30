package com.grupo5.resenalibro.dto;

import java.time.LocalDateTime;

public class ResenaRequest {
    public String externalId;
    public Long usuarioId;
    public String contenido;
    public LocalDateTime fecha;
    public Integer puntuacion;
}
